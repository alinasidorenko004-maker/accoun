package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import dao.DealDAO;
import dao.SubAccountDAO;
import domain.Deal;

@WebServlet("/deal")
public class DealServlet extends HttpServlet {

    private DealDAO dao = new DealDAO();
    private SubAccountDAO subDAO = new SubAccountDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            req.setAttribute("deals", dao.findAll());
            req.setAttribute("subaccounts", subDAO.findAll()); // добавлено
            req.getRequestDispatcher("/views/deal.jsp").forward(req, resp);
            return;
        }

        

        if ("delete".equals(action)) {
            dao.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("deal");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        String dateStr = req.getParameter("date");
        java.sql.Timestamp date = null;

        try {
            if (dateStr != null && !dateStr.isEmpty()) {
                dateStr = dateStr.replace("T", " ") + ":00"; // FIX
                date = java.sql.Timestamp.valueOf(dateStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if ("update".equals(action)) {
            dao.update(new Deal(
                    Integer.parseInt(req.getParameter("id")),
                    req.getParameter("agreement"),
                    req.getParameter("tiker"),
                    req.getParameter("order"),
                    req.getParameter("number"),
                    date,
                    Integer.parseInt(req.getParameter("quantity")),
                    Double.parseDouble(req.getParameter("price")),
                    Double.parseDouble(req.getParameter("totalCost")),
                    req.getParameter("trader"),
                    Double.parseDouble(req.getParameter("commission"))
            ));
        } else {
            dao.insert(new Deal(
                    req.getParameter("agreement"),
                    req.getParameter("tiker"),
                    req.getParameter("order"),
                    req.getParameter("number"),
                    date,
                    Integer.parseInt(req.getParameter("quantity")),
                    Double.parseDouble(req.getParameter("price")),
                    Double.parseDouble(req.getParameter("totalCost")),
                    req.getParameter("trader"),
                    Double.parseDouble(req.getParameter("commission"))
            ));
        }

        resp.sendRedirect("deal");
    }
}