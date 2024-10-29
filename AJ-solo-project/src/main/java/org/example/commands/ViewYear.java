package org.example.commands;

import org.example.simpleClasses.Account;
import org.example.simpleClasses.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewYear extends Command{
    private final Scanner scanner = new Scanner(System.in);
    public ViewYear(String name) {
        super(name);
    }

    @Override
    public void execute(Account account) {
        System.out.println("Enter a date yyyy-mm-dd: ");
        String date = scanner.nextLine();
        LocalDate parsedDate = LocalDate.parse(date);
        int totalAmount;
        List<Transaction> sortedByYear = account.getTransactions().stream()
                .filter(transaction -> transaction.getDate().getYear() == parsedDate.getYear())
                .collect(Collectors.toList());
        System.out.println(sortedByYear);
    }

    @Override
    public String description() {
        return "View Year";
    }
}
