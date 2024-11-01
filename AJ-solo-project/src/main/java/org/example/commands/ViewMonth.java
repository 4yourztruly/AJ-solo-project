package org.example.commands;

import org.example.simpleClasses.Account;
import org.example.simpleClasses.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewMonth extends Command{
    private final Scanner scanner = new Scanner(System.in);
    public ViewMonth(String name) {
        super(name);
    }

    @Override
    public void execute(Account account) {
        System.out.println("Enter a date yyyy-mm-dd: ");
        String date = scanner.nextLine();
        LocalDate parsedDate = LocalDate.parse(date);
        List<Transaction> sortedByMonth = account.getTransactions().stream()
                .filter(transaction -> transaction.getDate().getMonth() == parsedDate.getMonth())
                .toList();
        System.out.println();
        if(sortedByMonth.isEmpty()) {
            System.out.println("Entered month is empty! ");
            System.out.println();
            return;
        }
        sortedByMonth.forEach(System.out::println);
        System.out.println();

        int monthSum = account.getTransactions().stream().filter(transaction -> transaction.getDate().getMonth() == parsedDate.getMonth())
                .mapToInt(Transaction::getPrice).sum();
        System.out.println(parsedDate.getMonth() + " total sum balance: "+ monthSum + "kr ");
        System.out.println();

    }

    @Override
    public String description() {
        return "View Month";
    }
}
