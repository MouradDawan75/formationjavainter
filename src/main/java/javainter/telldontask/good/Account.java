package javainter.telldontask.good;

public class Account {
    private int id;
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withDraw(double amount) throws IllegalAccessException {
        if(balance < amount){
            throw new IllegalAccessException(("Error: not enough money!"));

        }
        balance -= amount;
    }
}
