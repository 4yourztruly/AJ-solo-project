package org.example.simpleClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    private final String name;
    private final int price;
    private final LocalDate date;

    public Transaction(String name, int price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }
}
