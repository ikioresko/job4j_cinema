package ru.job4j.cinema.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.cinema.model.Account;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.service.PsqlStoreService;
import ru.job4j.cinema.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CheckoutServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(PsqlStore.class.getName());
    private final PsqlStoreService serviceStore;

    public CheckoutServlet() {
        this.serviceStore = new PsqlStoreService(PsqlStore.instOf());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        req.setCharacterEncoding("UTF-8");
        String phone = req.getParameter("phone");
        String userName = req.getParameter("username");
        Account account = serviceStore.findAccountByPhone(phone);
        if (account == null) {
            account = serviceStore.createAccount(
                    Account.accountOf(
                            0, userName, userName + "@example.com", Integer.parseInt(phone)));
        }
        String[] rowCell = req.getParameter("rowCell").split(":");
        int row = Integer.parseInt(rowCell[0]);
        int cell = Integer.parseInt(rowCell[1]);
        int placeId = Integer.parseInt(rowCell[2]);
        Ticket ticket = Ticket.ticketOf(0, 2, row, cell, account.getId());
        try {
            serviceStore.createTicket(ticket);
        } catch (SQLException e) {
            LOG.error("Exception: ", e);
            req.setAttribute("error", "Место уже занято, пожалуйста выберите другое");
        }
        req.setAttribute("error", "Место успешно забронировано");
        serviceStore.reservePlace(placeId);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
