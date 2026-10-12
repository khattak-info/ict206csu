package examPractice;

class OpalTicket {
    private String holder;
    private double balance;

    public OpalTicket(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

