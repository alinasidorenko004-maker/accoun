<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="views/header.jsp"/>

<div class="container mt-5">

    <div class="text-center mb-5">
        <h2 class="fw-bold">Система учета</h2>
        <p class="text-muted">Управление счетами, сделками и операциями</p>
    </div>

    <div class="row g-4">

     
        <div class="col-md-6 col-lg-3">
            <a href="accountplan" class="text-decoration-none">
                <div class="card shadow-sm h-100 border-0 hover-card">
                    <div class="card-body text-center">
                        <h5 class="fw-bold">План счетов</h5>
                        <p class="text-muted small">Все счета системы</p>
                    </div>
                </div>
            </a>
        </div>

      
        <div class="col-md-6 col-lg-3">
            <a href="subaccount" class="text-decoration-none">
                <div class="card shadow-sm h-100 border-0 hover-card">
                    <div class="card-body text-center">
                        <h5 class="fw-bold">Субсчета</h5>
                        <p class="text-muted small">Детализация счетов</p>
                    </div>
                </div>
            </a>
        </div>

    
        <div class="col-md-6 col-lg-3">
            <a href="deal" class="text-decoration-none">
                <div class="card shadow-sm h-100 border-0 hover-card">
                    <div class="card-body text-center">
                        <h5 class="fw-bold">Сделки</h5>
                        <p class="text-muted small">История операций</p>
                    </div>
                </div>
            </a>
        </div>

      
        <div class="col-md-6 col-lg-3">
            <a href="operation" class="text-decoration-none">
                <div class="card shadow-sm h-100 border-0 hover-card">
                    <div class="card-body text-center">
                        <h5 class="fw-bold">Операции</h5>
                        <p class="text-muted small">Финансовые движения</p>
                    </div>
                </div>
            </a>
        </div>

    </div>

</div>

<style>
.hover-card {
    transition: all 0.2s ease;
    cursor: pointer;
}

.hover-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 8px 20px rgba(0,0,0,0.1);
}
</style>

<jsp:include page="views/footer.jsp"/>