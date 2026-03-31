package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import dao.AccountPlanDAO;
import domain.AccountPlan;

@WebServlet("/accountplan")
public class AccountPlanServlet extends HttpServlet {

    private AccountPlanDAO dao = new AccountPlanDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            req.setAttribute("accountplans", dao.findAll());
            req.getRequestDispatcher("/views/accountplan.jsp").forward(req, resp);
            return;
        }

        if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));

            req.setAttribute("accountplan", dao.findById(id));
            req.getRequestDispatcher("/views/editaccountplan.jsp").forward(req, resp);
        }

        if ("delete".equals(action)) {
            dao.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("accountplan");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        if ("update".equals(action)) {
            dao.update(new AccountPlan(
                    Integer.parseInt(req.getParameter("id")),
                    req.getParameter("name"),
                    req.getParameter("type"),
                    req.getParameter("number")
            ));
        } else {
            dao.insert(new AccountPlan(
                    req.getParameter("name"),
                    req.getParameter("type"),
                    req.getParameter("number")
            ));
        }

        resp.sendRedirect("accountplan");
    }
}