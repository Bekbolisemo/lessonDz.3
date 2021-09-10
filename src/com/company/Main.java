package com.company;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        out.println("какую сумму вы хотите ввисти?");
        bankAccount.deposit(scanner.nextDouble());
        while (true) {
            try {
                out.println("у выс на счете " + bankAccount.getAmount());
                bankAccount.withDraw(6000);
            } catch (LimitException e) {
                out.println(e.getMessage());
                try {
                    bankAccount.withDraw((int) bankAccount.getAmount());
                    out.println("ост счета" + bankAccount.getAmount());

                } catch (LimitException limitException) {
                    limitException.printStackTrace();
                }
                break;
            }
        }
    }
}

