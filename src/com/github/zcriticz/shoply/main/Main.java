package com.github.zcriticz.shoply.main;

import com.github.zcriticz.shoply.model.CreditCard;
import com.github.zcriticz.shoply.model.Transaction;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputValue = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limit = inputValue.nextDouble();
        CreditCard creditCard = new CreditCard(limit);

        int exit = 1;
        while (exit != 0) {
            System.out.println("Digite a descrição da compra: ");
            String description = inputValue.next();

            System.out.println("Digite o valor da compra:");
            double amount = inputValue.nextDouble();

            Transaction transaction = new Transaction(description, amount);
            boolean success = creditCard.makePurchase(transaction);

            if (success) {
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Digite 0 para sair ou 1 para continuar: ");
                exit = inputValue.nextInt();
            } else {
                System.out.println("Compra não realizada.\n");
                exit = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        for (Transaction item : creditCard.getTransactions()) {
            System.out.println("Produto: " + item.getDescription() + ", Valor: " + item.getAmount());
        }
        Collections.sort(creditCard.getTransactions());
        System.out.println("\n***********************");
        System.out.println("Saldo restante: " + creditCard.getBalance());
    }
}