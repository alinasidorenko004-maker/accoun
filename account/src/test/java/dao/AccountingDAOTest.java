package dao;

import domain.AccountPlan;
import domain.Deal;
import domain.Operation;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

public class AccountingDAOTest {

    @Test
    public void shouldReturnAccountPlans() {
        AccountPlanDAO dao = new AccountPlanDAO();

        List<AccountPlan> list = dao.findAll();

        assertNotNull(list);
    }

    @Test
    public void shouldInsertAccountPlan() {
        AccountPlanDAO dao = new AccountPlanDAO();

        String unique = "TestPlan_" + System.currentTimeMillis();

        AccountPlan a = new AccountPlan();
        a.setName(unique);
        a.setType("TEST");
        a.setNumber("999");

        dao.insert(a);

        List<AccountPlan> list = dao.findAll();

        boolean found = list.stream()
                .anyMatch(x -> unique.equals(x.getName()));

        assertTrue(found);
    }

    @Test
    public void shouldInsertDeal() {
        DealDAO dao = new DealDAO();

        String unique = "Deal_" + System.currentTimeMillis();

        Deal d = new Deal(
                "AGR",
                "TST",
                "ORD",
                unique,
                new Timestamp(System.currentTimeMillis()),
                10,
                100.5,
                1005.0,
                "Tester",
                1.5
        );

        dao.insert(d);

        List<Deal> list = dao.findAll();

        boolean found = list.stream()
                .anyMatch(x -> unique.equals(x.getNumber()));

        assertTrue(found);
    }

    @Test
    public void shouldInsertOperation() {
        OperationDAO dao = new OperationDAO();

        // ВАЖНО: должны существовать записи dealId=1 и subAccountId=1
        Operation o = new Operation(
                1,
                1,
                "OP_" + System.currentTimeMillis(),
                new java.util.Date(),
                "BUY",
                500.0,
                1000.0,
                1500.0
        );

        dao.insert(o);

        List<Operation> list = dao.findAll();

        boolean found = list.stream()
                .anyMatch(x -> x.getNumber().contains("OP_"));

        assertTrue(found);
    }
}