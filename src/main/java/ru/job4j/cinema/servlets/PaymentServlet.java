package ru.job4j.cinema.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaymentServlet extends HttpServlet {
    private String[] rowCell;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setAttribute("row", rowCell[0]);
        req.setAttribute("cell", rowCell[1]);
        req.setAttribute("id", rowCell[2]);
        req.getRequestDispatcher("/payment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        req.setCharacterEncoding("UTF-8");
        rowCell = req.getParameter("place").split(":");
        resp.sendRedirect(req.getContextPath() + "/payment.do");
    }
}
