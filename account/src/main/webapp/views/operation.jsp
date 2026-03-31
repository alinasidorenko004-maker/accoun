<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, domain.Operation, domain.Deal, domain.SubAccount" %>

<jsp:include page="header.jsp"/>

<div class="container mt-4">

    <h4>Операции</h4>

    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Сделка</th>
            <th>Субсчет</th>
            <th>Номер</th>
            <th>Дата</th>
            <th>Тип</th>
            <th>Сумма</th>
            <th>Начальное</th>
            <th>Конечное</th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <%
            List<Operation> list = (List<Operation>) request.getAttribute("operations");
            List<Deal> deals = (List<Deal>) request.getAttribute("deals");
            List<SubAccount> subs = (List<SubAccount>) request.getAttribute("subs");

            if (list != null) {
                for (Operation o : list) {
        %>
        <tr>
            <form action="operation" method="post">

                <td>
                    <%=o.getId()%>
                    <input type="hidden" name="id" value="<%=o.getId()%>">
                    <input type="hidden" name="action" value="update">
                </td>

                <td>
                    <select name="dealId" class="form-select">
                        <%
                            for (Deal d : deals) {
                        %>
                        <option value="<%=d.getId()%>" <%=d.getNumber().equals(o.getDealNumber()) ? "selected" : ""%>>
                            <%=d.getNumber()%>
                        </option>
                        <% } %>
                    </select>
                </td>

                <td>
                    <select name="subAccountId" class="form-select">
                        <%
                            for (SubAccount s : subs) {
                        %>
                        <option value="<%=s.getId()%>" <%=s.getName().equals(o.getSubAccountName()) ? "selected" : ""%>>
                            <%=s.getName()%>
                        </option>
                        <% } %>
                    </select>
                </td>

                <td><input type="text" name="number" class="form-control" value="<%=o.getNumber()%>"></td>

                <td>
                    <input type="date" name="date" class="form-control"
                           value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(o.getDate()) %>">
                </td>

                <td>
                    <select name="type" class="form-select">
                        <option value="BUY" <%= "BUY".equals(o.getType()) ? "selected" : "" %>>BUY</option>
                        <option value="SELL" <%= "SELL".equals(o.getType()) ? "selected" : "" %>>SELL</option>
                    </select>
                </td>

                <td><input type="text" name="sum" class="form-control" value="<%=o.getSum()%>"></td>
                <td><input type="text" name="saldoInput" class="form-control" value="<%=o.getSaldoInput()%>"></td>
                <td><input type="text" name="saldoOutput" class="form-control" value="<%=o.getSaldoOutput()%>"></td>

                <td>
                    <button class="btn btn-success btn-sm">Сохранить</button>
                    <a href="operation?action=delete&id=<%=o.getId()%>" class="btn btn-danger btn-sm">Удалить</a>
                </td>

            </form>
        </tr>
        <% }} %>
        </tbody>
    </table>

    <!-- ДОБАВЛЕНИЕ -->
    <form action="operation" method="post" class="mt-4">
        <input type="hidden" name="action" value="insert">

        <div class="row g-2">

            <div class="col-md-3">
                <select name="dealId" class="form-select">
                    <% for (Deal d : deals) { %>
                    <option value="<%=d.getId()%>"><%=d.getNumber()%></option>
                    <% } %>
                </select>
            </div>

            <div class="col-md-3">
                <select name="subAccountId" class="form-select">
                    <% for (SubAccount s : subs) { %>
                    <option value="<%=s.getId()%>"><%=s.getName()%></option>
                    <% } %>
                </select>
            </div>

            <div class="col-md-2">
                <input type="text" name="number" class="form-control" placeholder="Номер">
            </div>

            <div class="col-md-2">
                <input type="date" name="date" class="form-control">
            </div>

            <div class="col-md-2">
                <select name="type" class="form-select">
                    <option value="BUY">BUY</option>
                    <option value="SELL">SELL</option>
                </select>
            </div>

            <div class="col-md-2">
                <input type="text" name="sum" class="form-control" placeholder="Сумма">
            </div>

            <div class="col-md-2">
                <input type="text" name="saldoInput" class="form-control" placeholder="Начальное">
            </div>

            <div class="col-md-2">
                <input type="text" name="saldoOutput" class="form-control" placeholder="Конечное">
            </div>

            <div class="col-md-2">
                <button class="btn btn-primary w-100">Добавить</button>
            </div>

        </div>
    </form>

</div>

<jsp:include page="footer.jsp"/>