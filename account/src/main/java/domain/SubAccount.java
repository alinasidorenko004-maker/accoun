package domain;

public class SubAccount {

    private int id;
    private int accountPlanId;
    private String name;
    private String number;

    private String accountPlanName;

    public SubAccount() {}

    public SubAccount(int accountPlanId, String name, String number) {
        this.accountPlanId = accountPlanId;
        this.name = name;
        this.number = number;
    }

    public SubAccount(int id, int accountPlanId, String name, String number) {
        this.id = id;
        this.accountPlanId = accountPlanId;
        this.name = name;
        this.number = number;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAccountPlanId() { return accountPlanId; }
    public void setAccountPlanId(int accountPlanId) { this.accountPlanId = accountPlanId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getAccountPlanName() { return accountPlanName; }
    public void setAccountPlanName(String accountPlanName) { this.accountPlanName = accountPlanName; }
}