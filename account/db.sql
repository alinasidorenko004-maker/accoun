-- =========================
-- 1. AccountPlan
-- =========================
CREATE TABLE AccountPlan (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(100),
    number VARCHAR(50)
);

INSERT INTO AccountPlan (name, type, number) VALUES
('Счет клиентов', 'расчетный', '101'),
('Счет контрагентов', 'валютный', '102'),
('Комиссионный доход', 'касса', '103');


-- =========================
-- 2. SubAccount
-- =========================
CREATE TABLE SubAccount (
    id SERIAL PRIMARY KEY,
    accountPlanId INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    number VARCHAR(50),

    FOREIGN KEY (accountPlanId) REFERENCES AccountPlan(id)
        ON DELETE CASCADE
);

INSERT INTO SubAccount (accountPlanId, name, number) VALUES
(1, 'Брокерские операции', '201'),
(1, 'Дилерские операции', '202'),
(2, 'Доверительное управление', '203');


-- =========================
-- 3. Deal
-- =========================
CREATE TABLE Deal (
    id SERIAL PRIMARY KEY,
    agreement VARCHAR(100),
    tiker VARCHAR(50),
    "order" VARCHAR(50),
    number VARCHAR(50),
    date TIMESTAMP,
    quantity INT,
    price NUMERIC(15,2),
    totalCost NUMERIC(15,2),
    trader VARCHAR(100),
    commission NUMERIC(10,2)
);

INSERT INTO Deal (agreement, tiker, "order", number, date, quantity, price, totalCost, trader, commission) VALUES
('AG-001', 'AAPL', 'ORD-001', 'D-001', NOW(), 10, 150.00, 1500.00, 'TR-01', 15.00),
('AG-002', 'GOOGL', 'ORD-002', 'D-002', NOW(), 5, 2000.00, 10000.00, 'TR-02', 50.00),
('AG-003', 'TSLA', 'ORD-003', 'D-003', NOW(), 3, 700.00, 2100.00, 'TR-03', 20.00);


-- =========================
-- 4. Operation
-- =========================
CREATE TABLE Operation (
    id SERIAL PRIMARY KEY,
    dealId INT NOT NULL,
    subAccountId INT NOT NULL,

    number VARCHAR(50),
    date DATE,
    type VARCHAR(50),

    sum NUMERIC(15,2),
    saldoInput NUMERIC(15,2),
    saldoOutput NUMERIC(15,2),

    FOREIGN KEY (dealId) REFERENCES Deal(id)
        ON DELETE CASCADE,

    FOREIGN KEY (subAccountId) REFERENCES SubAccount(id)
        ON DELETE CASCADE
);

INSERT INTO Operation (dealId, subAccountId, number, date, type, sum, saldoInput, saldoOutput) VALUES
(1, 1, 'OP-001', CURRENT_DATE, 'BUY', 1500.00, 0.00, 1500.00),
(2, 2, 'OP-002', CURRENT_DATE, 'SELL', 10000.00, 1500.00, 11500.00),
(3, 3, 'OP-003', CURRENT_DATE, 'BUY', 2100.00, 11500.00, 13600.00);