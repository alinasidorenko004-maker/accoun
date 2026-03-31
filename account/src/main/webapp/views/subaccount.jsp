<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, domain.SubAccount, domain.AccountPlan" %>

<jsp:include page="header.jsp"/>

<div class="container mt-4">

    <h4>Субсчета</h4>

    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>План счетов</th>
            <th>Название</th>
            <th>Номер</th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <%
            List<SubAccount> list = (List<SubAccount>) request.getAttribute("subaccounts");
            List<AccountPlan> plans = (List<AccountPlan>) request.getAttribute("plans");

            if (list != null) {
                for (SubAccount s : list) {
        %>
        <tr>
            <form action="subaccount" method="post">

                <td>
                    <%=s.getId()%>
                    <input type="hidden" name="id" value="<%=s.getId()%>">
                    <input type="hidden" name="action" value="update">
                </td>

                <td>
                    <select name="accountPlanId" class="form-select">
                        <%
                            if (plans != null) {
                                for (AccountPlan p : plans) {
                        %>
                        <option value="<%=p.getId()%>"
                            <%= (p.getId() == s.getAccountPlanId() ? "selected" : "") %>>
                            <%=p.getName()%>
                        </option>
                        <% }} %>
                    </select>
                </td>

                <td>
                    <input type="text" name="name" class="form-control"
                           value="<%=s.getName()%>">
                </td>

                <td>
                    <input type="text" name="number" class="form-control"
                           value="<%=s.getNumber()%>">
                </td>

                <td>
                    <button class="btn btn-success btn-sm">Сохранить</button>
                    <a href="subaccount?action=delete&id=<%=s.getId()%>" class="btn btn-danger btn-sm">Удалить</a>
                </td>

            </form>
        </tr>
        <% }} %>
        </tbody>
    </table>

    <!-- ДОБАВЛЕНИЕ -->
    <form action="subaccount" method="post" class="mt-4">
        <input type="hidden" name="action" value="insert">

        <div class="row g-2">

            <div class="col-md-3">
                <select name="accountPlanId" class="form-select">
                    <%
                        if (plans != null) {
                            for (AccountPlan p : plans) {
                    %>
                    <option value="<%=p.getId()%>"><%=p.getName()%></option>
                    <% }} %>
                </select>
            </div>

            <div class="col-md-4">
                <input type="text" name="name" class="form-control" placeholder="Название" required>
            </div>

            <div class="col-md-3">
                <input type="text" name="number" class="form-control" placeholder="Номер">
            </div>

            <div class="col-md-2">
                <button class="btn btn-primary w-100">Добавить</button>
            </div>

        </div>
    </form>

</div>

<jsp:include page="footer.jsp"/>