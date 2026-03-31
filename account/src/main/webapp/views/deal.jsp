<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, domain.Deal" %>

<jsp:include page="header.jsp"/>

<div class="container mt-4">

    <h4>Сделки</h4>

    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Договор</th>
            <th>Тикер</th>
            <th>Ордер</th>
            <th>Номер</th>
            <th>Дата</th>
            <th>Кол-во</th>
            <th>Цена</th>
            <th>Сумма</th>
            <th>Трейдер</th>
            <th>Комиссия</th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <%
            List<Deal> list = (List<Deal>) request.getAttribute("deals");
            if (list != null) {
                for (Deal d : list) {
        %>
        <tr>
            <form action="deal" method="post">

                <td>
                    <%=d.getId()%>
                    <input type="hidden" name="id" value="<%=d.getId()%>">
                    <input type="hidden" name="action" value="update">
                </td>

                <td><input type="text" name="agreement" class="form-control" value="<%=d.getAgreement()%>"></td>
                <td><input type="text" name="tiker" class="form-control" value="<%=d.getTiker()%>"></td>
                <td><input type="text" name="order" class="form-control" value="<%=d.getOrder()%>"></td>
                <td><input type="text" name="number" class="form-control" value="<%=d.getNumber()%>"></td>

                <td>
                    <input type="datetime-local" name="date" class="form-control"
                           value="<%= d.getDate() != null ? d.getDate().toLocalDateTime().toString().substring(0,16) : "" %>">
                </td>

                <td><input type="number" name="quantity" class="form-control" value="<%=d.getQuantity()%>"></td>
                <td><input type="number" step="0.01" name="price" class="form-control" value="<%=d.getPrice()%>"></td>
                <td><input type="number" step="0.01" name="totalCost" class="form-control" value="<%=d.getTotalCost()%>"></td>
                <td><input type="text" name="trader" class="form-control" value="<%=d.getTrader()%>"></td>
                <td><input type="number" step="0.01" name="commission" class="form-control" value="<%=d.getCommission()%>"></td>

                <td>
                    <button class="btn btn-success btn-sm">Сохранить</button>
                    <a href="deal?action=delete&id=<%=d.getId()%>" class="btn btn-danger btn-sm">Удалить</a>
                </td>

            </form>
        </tr>
        <% }} %>
        </tbody>
    </table>

    <!-- ДОБАВЛЕНИЕ -->
    <form action="deal" method="post" class="mt-4">
        <input type="hidden" name="action" value="insert">

        <div class="row g-2">

            <div class="col-md-2">
                <input type="text" name="agreement" class="form-control" placeholder="Договор">
            </div>

            <div class="col-md-2">
                <input type="text" name="tiker" class="form-control" placeholder="Тикер">
            </div>

            <div class="col-md-2">
                <input type="text" name="order" class="form-control" placeholder="Ордер">
            </div>

            <div class="col-md-2">
                <input type="text" name="number" class="form-control" placeholder="Номер">
            </div>

            <div class="col-md-2">
                <input type="datetime-local" name="date" class="form-control">
            </div>

            <div class="col-md-2">
                <input type="number" name="quantity" class="form-control" placeholder="Кол-во">
            </div>

            <div class="col-md-2">
                <input type="number" step="0.01" name="price" class="form-control" placeholder="Цена">
            </div>

            <div class="col-md-2">
                <input type="number" step="0.01" name="totalCost" class="form-control" placeholder="Сумма">
            </div>

            <div class="col-md-2">
                <input type="text" name="trader" class="form-control" placeholder="Трейдер">
            </div>

            <div class="col-md-2">
                <input type="number" step="0.01" name="commission" class="form-control" placeholder="Комиссия">
            </div>

            <div class="col-md-2">
                <button class="btn btn-primary w-100">Добавить</button>
            </div>

        </div>
    </form>

</div>

<jsp:include page="footer.jsp"/>