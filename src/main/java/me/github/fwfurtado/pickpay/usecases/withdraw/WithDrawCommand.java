package me.github.fwfurtado.pickpay.usecases.withdraw;

import me.github.fwfurtado.pickpay.domain.Customer;

import java.math.BigDecimal;

public abstract class WithDrawCommand {

    protected final Customer customer;

    public WithDrawCommand(Customer customer) {
        this.customer =  customer;
    }

    public abstract void withDraw(BigDecimal amount);
}
