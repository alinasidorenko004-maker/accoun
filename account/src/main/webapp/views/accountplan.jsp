<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, domain.AccountPlan" %>

<jsp:include page="header.jsp"/>

<div class="container mt-4">

    <h4>План счетов</h4>

    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Тип</th>
            <th>Номер</th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <%
            List<AccountPlan> list = (List<AccountPlan>) request.getAttribute("accountplans");
            if (list != null) {
                for (AccountPlan a : list) {
        %>

        <tr>
            <form action="accountplan" method="post">

                <td>
                    <%=a.getId()%>
                    <input type="hidden" name="id" value="<%=a.getId()%>">
                    <input type="hidden" name="action" value="update">
                </td>

                <td>
                    <input type="text" name="name" class="form-control"
                           value="<%=a.getName()%>">
                </td>

                <td>
                    <input type="text" name="type" class="form-control"
                           value="<%=a.getType()%>">
                </td>

                <td>
                    <input type="text" name="number" class="form-control"
                           value="<%=a.getNumber()%>">
                </td>

                <td>
                    <button class="btn btn-success btn-sm">Сохранить</button>
                    <a href="accountplan?action=delete&id=<%=a.getId()%>" class="btn btn-danger btn-sm">Удалить</a>
                </td>

            </form>
        </tr>

        <% }} %>
        </tbody>
    </table>

    <!-- ДОБАВЛЕНИЕ -->
    <form action="accountplan" method="post" class="mt-4">
        <input type="hidden" name="action" value="insert">

        <div class="row g-2">
            <div class="col-md-4">
                <input type="text" name="name" class="form-control" placeholder="Название" required>
            </div>
            <div class="col-md-3">
                <input type="text" name="type" class="form-control" placeholder="Тип">
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