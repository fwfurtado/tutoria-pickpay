package me.github.fwfurtado.pickpay.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Wallet {
    @Getter
    private BigDecimal balance = BigDecimal.ZERO;
    private List<Transaction> transactions = new ArrayList<>();

    public void deposit(Transaction incoming) {
        transactions.add(incoming);
        balance = balance.add(incoming.getAmount());
    }

    public Iterable<Transaction> getTransactions() {
        return transactions;
    }
}
