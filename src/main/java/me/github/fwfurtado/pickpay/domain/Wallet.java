package me.github.fwfurtado.pickpay.domain;

import lombok.Getter;
import me.github.fwfurtado.pickpay.exception.NotAllowedOperationException;
import me.github.fwfurtado.pickpay.utils.MathUtils;

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

    public void withdraw(Transaction outcoming) throws NotAllowedOperationException {
        transactions.add(outcoming);
        if(MathUtils.isLessThan(this.balance, outcoming.getAmount()))
            throw new NotAllowedOperationException("You do not have enough balance for this operation");

        balance = balance.subtract(outcoming.getAmount());
    }
}
