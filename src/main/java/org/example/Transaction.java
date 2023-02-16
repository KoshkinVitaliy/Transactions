package org.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.time.ZoneId.SHORT_IDS;

public class Transaction {

    private ZonedDateTime time;
    private String zoneOfTransaction;
    private String initials;

    private double amountOfTransaction;
    private void makeTimeOfTransaction(String zoneOfTransaction) {
        time = ZonedDateTime.now(ZoneId.of(SHORT_IDS.get(zoneOfTransaction)));

        //System.out.println(time);
    }

    private void makeInitials() {
        System.out.println("Введите имя:");

        Scanner scannerForName = new Scanner(System.in);
        String name = scannerForName.next();

        initials = String.valueOf(name.charAt(0)).toUpperCase();

        //System.out.println(initials);
    }

    private void makeTransaction() {
        System.out.println("Введите часовой пояс: ");

        try {
            Scanner scanner = new Scanner(System.in);
            zoneOfTransaction = scanner.next();

            makeTimeOfTransaction(zoneOfTransaction);
        }
        catch (Exception e) {
            System.out.println("Вы ввели неккоретный формат часового пояса. Попробуйте ещё раз.");

            makeTransaction();
        }

    }

    private void takeAmountOfTransaction() {
        System.out.println("Введите сумму транзакции: ");
        try {
            Scanner scannerOfAmount = new Scanner(System.in);
            amountOfTransaction = scannerOfAmount.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Вы ввели неверное значение, попробуйте ещё раз.");

            takeAmountOfTransaction();
        }

    }

    public void showTransaction() {
        makeTransaction();
        makeInitials();
        takeAmountOfTransaction();

        System.out.println(time);
        System.out.println(initials);
        System.out.println(amountOfTransaction);
    }
}
