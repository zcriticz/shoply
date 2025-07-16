package com.github.zcriticz.shoply.model;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Transaction> transactions;

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.transactions = new ArrayList<>();
    }

    public boolean makePurchase(Transaction transaction) {
        if (transaction.getAmount() <= balance) {
            transactions.add(transaction);
            balance -= transaction.getAmount();
            return true;
        } else {
            System.out.println("Saldo insuficiente para a compra: " + transaction.getDescription() + "\n");
            return false;
        }
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
