package entities;

public class Account {
    private double balance;
    private double totalAmountTransferred;

    public double getBalance() {
        return balance;
    }

    public double getTotalAmountTransferred() {
        return totalAmountTransferred;
    }

    public boolean deposit(double amount) {
        if (amount <= 0)
            return false;
        else {
            balance += amount;
            return true;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            return false;
        else {
            balance -= amount;
            return true;
        }
    }

    public boolean transfer(Account destination, double amount) {
        if (amount <= 0 || amount > balance)
            return false;
        else {
            balance -= amount;
            destination.balance += amount;
            totalAmountTransferred += amount;
            return true;
        }
    }
}
