package domain;

import java.util.Date;

public class Operation {

    private int id;
    private int dealId;
    private int subAccountId;
    private String number;
    private Date date;
    private String type;
    private double sum;
    private double saldoInput;
    private double saldoOutput;

    private String dealNumber;
    private String subAccountName;

    public Operation() {}

    public Operation(int dealId, int subAccountId, String number,
                     Date date, String type, double sum,
                     double saldoInput, double saldoOutput) {
        this.dealId = dealId;
        this.subAccountId = subAccountId;
        this.number = number;
        this.date = date;
        this.type = type;
        this.sum = sum;
        this.saldoInput = saldoInput;
        this.saldoOutput = saldoOutput;
    }

    public Operation(int id, int dealId, int subAccountId, String number,
                     Date date, String type, double sum,
                     double saldoInput, double saldoOutput) {
        this(dealId, subAccountId, number, date, type, sum, saldoInput, saldoOutput);
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getDealId() { return dealId; }
    public void setDealId(int dealId) { this.dealId = dealId; }

    public int getSubAccountId() { return subAccountId; }
    public void setSubAccountId(int subAccountId) { this.subAccountId = subAccountId; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getSum() { return sum; }
    public void setSum(double sum) { this.sum = sum; }

    public double getSaldoInput() { return saldoInput; }
    public void setSaldoInput(double saldoInput) { this.saldoInput = saldoInput; }

    public double getSaldoOutput() { return saldoOutput; }
    public void setSaldoOutput(double saldoOutput) { this.saldoOutput = saldoOutput; }

    public String getDealNumber() { return dealNumber; }
    public void setDealNumber(String dealNumber) { this.dealNumber = dealNumber; }

    public String getSubAccountName() { return subAccountName; }
    public void setSubAccountName(String subAccountName) { this.subAccountName = subAccountName; }
}