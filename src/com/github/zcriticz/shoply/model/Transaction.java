package com.github.zcriticz.shoply.model;

public class Transaction implements Comparable<Transaction> {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "descrição='" + description + '\'' +
                ", valor=" + amount +
                '}';
    }

    @Override
    public int compareTo(Transaction otherTransaction) {
        return Double.valueOf(this.amount).compareTo(Double.valueOf(otherTransaction.amount));
    }
}
