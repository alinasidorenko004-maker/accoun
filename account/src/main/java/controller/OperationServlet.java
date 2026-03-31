package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import dao.OperationDAO;
import dao.DealDAO;
import dao.SubAccountDAO;
import domain.Operation;

@WebServlet("/operation")
public class OperationServlet extends HttpServlet {

    private OperationDAO dao = new OperationDAO();
    private DealDAO dealDAO = new DealDAO();
    private SubAccountDAO subDAO = new SubAccountDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("operations", dao.findAll());
        req.setAttribute("deals", dealDAO.findAll());
        req.setAttribute("subs", subDAO.findAll());

        req.getRequestDispatcher("/views/operation.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        try {
            String dateStr = req.getParameter("date");
            java.util.Date date = null;

            if (dateStr != null && !dateStr.isEmpty()) {
                date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            }

            if ("update".equals(req.getParameter("action"))) {

                dao.update(new Operation(
                        Integer.parseInt(req.getParameter("id")),
                        Integer.parseInt(req.getParameter("dealId")),
                        Integer.parseInt(req.getParameter("subAccountId")),
                        req.getParameter("number"),
                        date,
                        req.getParameter("type"),
                        Double.parseDouble(req.getParameter("sum")),
                        Double.parseDouble(req.getParameter("saldoInput")),
                        Double.parseDouble(req.getParameter("saldoOutput"))
                ));

            } else {

                dao.insert(new Operation(
                        Integer.parseInt(req.getParameter("dealId")),
                        Integer.parseInt(req.getParameter("subAccountId")),
                        req.getParameter("number"),
                        date,
                        req.getParameter("type"),
                        Double.parseDouble(req.getParameter("sum")),
                        Double.parseDouble(req.getParameter("saldoInput")),
                        Double.parseDouble(req.getParameter("saldoOutput"))
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("operation");
    }
}