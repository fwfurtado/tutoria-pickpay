package me.github.fwfurtado.pickpay.usecases.deposit;

import me.github.fwfurtado.pickpay.domain.Customer;

import java.math.BigDecimal;

public abstract class DepositCommand {

    protected final Customer customer;

    public DepositCommand(Customer customer) {
        this.customer =  customer;
    }

    public abstract void deposit(BigDecimal amount);
}
