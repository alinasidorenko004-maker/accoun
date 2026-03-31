<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Учет операций</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
</head>

<body>

<div class="header d-flex align-items-center justify-content-between px-4">

   
    <div class="logo">
        <a href="<%=request.getContextPath()%>/" class="text-decoration-none text-dark fw-bold">
            Финансовая система
        </a>
    </div>

  
    <div class="nav-links mx-auto d-flex gap-4">

        <a href="accountplan" class="nav-link">План счетов</a>
        <a href="subaccount" class="nav-link">Субсчета</a>
        <a href="deal" class="nav-link">Сделки</a>
        <a href="operation" class="nav-link">Операции</a>

    </div>

</div>

<style>
.header {
    height: 60px;
    border-bottom: 1px solid #eee;
    background: #fff;
}

.logo {
    font-size: 18px;
}

.nav-links a {
    color: #333;
    text-decoration: none;
    font-weight: 500;
}

.nav-links a:hover {
    color: #0d6efd;
}
</style>