package domain;

import java.sql.Timestamp;

public class Deal {

    private int id;
    private String agreement;
    private String tiker;
    private String order;
    private String number;
    private Timestamp date;
    private int quantity;
    private double price;
    private double totalCost;
    private String trader;
    private double commission;

    public Deal() {}

    public Deal(String agreement, String tiker, String order, String number,
                Timestamp date, int quantity, double price,
                double totalCost, String trader, double commission) {
        this.agreement = agreement;
        this.tiker = tiker;
        this.order = order;
        this.number = number;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = totalCost;
        this.trader = trader;
        this.commission = commission;
    }

    public Deal(int id, String agreement, String tiker, String order, String number,
                Timestamp date, int quantity, double price,
                double totalCost, String trader, double commission) {
        this(agreement, tiker, order, number, date, quantity, price, totalCost, trader, commission);
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAgreement() { return agreement; }
    public void setAgreement(String agreement) { this.agreement = agreement; }

    public String getTiker() { return tiker; }
    public void setTiker(String tiker) { this.tiker = tiker; }

    public String getOrder() { return order; }
    public void setOrder(String order) { this.order = order; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Timestamp getDate() { return date; }
    public void setDate(Timestamp date) { this.date = date; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public String getTrader() { return trader; }
    public void setTrader(String trader) { this.trader = trader; }

    public double getCommission() { return commission; }
    public void setCommission(double commission) { this.commission = commission; }
}