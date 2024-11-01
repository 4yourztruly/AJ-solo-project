package org.example.commands;

import org.example.simpleClasses.Account;
import org.example.simpleClasses.Transaction;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewWeek extends Command{
    private final Scanner scanner = new Scanner(System.in);
    public ViewWeek(String name) {
        super(name);
    }

    @Override
    public void execute(Account account) {
        System.out.println("Enter a week number: ");
        int week = scanner.nextInt();
        List<Transaction> sortedByWeek = account.getTransactions().stream()
                .filter(transaction ->transaction
                        .getDate().get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear()) == week)
                .collect(Collectors.toList());
        System.out.println();
        if(sortedByWeek.isEmpty()) {
            System.out.println("Entered week is empty! ");
            System.out.println();
            return;
        }
        sortedByWeek.forEach(System.out::println);
        System.out.println();

        int weekSum = account.getTransactions().stream()
                .filter(transaction ->transaction
                        .getDate().get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear()) == week)
                .mapToInt(Transaction::getPrice).sum();
        System.out.println("Week: " + week + " total sum balance: "+ weekSum + "kr ");
        System.out.println();

    }

    @Override
    public String description() {
        return "View Week";
    }
}
