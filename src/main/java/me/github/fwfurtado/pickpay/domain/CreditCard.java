package me.github.fwfurtado.pickpay.domain;

import lombok.Getter;

import java.time.YearMonth;

@Getter
public class CreditCard {
    private String name;
    private String number;
    private Integer cvv;
    private YearMonth dueDate;

    public CreditCard(String name, String number, Integer cvv, YearMonth dueDate) {
        this.name = name;
        this.number = number;
        this.cvv = cvv;
        this.dueDate = dueDate;
    }
}
