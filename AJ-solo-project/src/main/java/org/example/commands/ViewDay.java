package org.example.commands;

import org.example.simpleClasses.Account;
import org.example.simpleClasses.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewDay extends Command{
    private final Scanner scanner = new Scanner(System.in);
    public ViewDay(String name) {
        super(name);
    }

    @Override
    public void execute(Account account) {
        System.out.println("Enter a date yyyy-mm-dd: ");
        String date = scanner.nextLine();
        LocalDate parsedDate = LocalDate.parse(date);
        List<Transaction> sortedByDay = account.getTransactions().stream()
                .filter(transaction -> transaction.getDate().getDayOfMonth() == parsedDate.getDayOfMonth())
                .toList();
        System.out.println();
        if(sortedByDay.isEmpty()) {
            System.out.println("Entered day is empty! ");
            System.out.println();
            return;
        }
        sortedByDay.forEach(System.out::println);
        System.out.println();

        int daySum = account.getTransactions().stream().filter(transaction -> transaction.getDate().getDayOfMonth() == parsedDate.getDayOfMonth())
                .mapToInt(Transaction::getPrice).sum();
        System.out.println("Day : " + parsedDate.getDayOfMonth() + " total sum balance: "+ daySum + "kr ");
        System.out.println();

    }

    @Override
    public String description() {
        return "View Day";
    }
}
