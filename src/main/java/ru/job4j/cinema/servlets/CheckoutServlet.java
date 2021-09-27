package ru.job4j.cinema.servlets;

import ru.job4j.cinema.model.Account;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.store.PsqlStore;
import ru.job4j.cinema.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        req.setCharacterEncoding("UTF-8");
        Store psStore = PsqlStore.instOf();
        String phone = req.getParameter("phone");
        String userName = req.getParameter("username");
        Account account = psStore.findAccountByPhone(phone);
        if (account == null) {
            account = psStore.createAccount(
                    Account.accountOf(
                            0, userName, userName + "@example.com", Integer.parseInt(phone)));
        }
        String[] rowCell = req.getParameter("rowCell").split(":");
        int row = Integer.parseInt(rowCell[0]);
        int cell = Integer.parseInt(rowCell[1]);
        int placeId = Integer.parseInt(rowCell[2]);
        Ticket ticket = psStore.getTicketByRowAndCell(row, cell);
        if (ticket == null) {
            ticket = Ticket.ticketOf(0, 2, row, cell, account.getId());
            psStore.createTicket(ticket);
            psStore.reservePlace(placeId);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            req.setAttribute("error", "Место уже занято, пожалуйста выберите другое");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
