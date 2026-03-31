package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import dao.SubAccountDAO;
import dao.AccountPlanDAO;
import domain.SubAccount;

@WebServlet("/subaccount")
public class SubAccountServlet extends HttpServlet {

    private SubAccountDAO dao = new SubAccountDAO();
    private AccountPlanDAO accountPlanDAO = new AccountPlanDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("subaccounts", dao.findAll());
        req.setAttribute("plans", accountPlanDAO.findAll());

        req.getRequestDispatcher("/views/subaccount.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        if ("update".equals(action)) {
            dao.update(new SubAccount(
                    Integer.parseInt(req.getParameter("id")),
                    Integer.parseInt(req.getParameter("accountPlanId")),
                    req.getParameter("name"),
                    req.getParameter("number")
            ));
        } else {
            dao.insert(new SubAccount(
                    Integer.parseInt(req.getParameter("accountPlanId")),
                    req.getParameter("name"),
                    req.getParameter("number")
            ));
        }

        resp.sendRedirect("subaccount");
    }
}