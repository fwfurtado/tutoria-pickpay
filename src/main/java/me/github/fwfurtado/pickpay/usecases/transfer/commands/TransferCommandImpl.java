package me.github.fwfurtado.pickpay.usecases.transfer.commands;

import io.vavr.control.Try;
import me.github.fwfurtado.pickpay.domain.Customer;
import me.github.fwfurtado.pickpay.exception.NotAllowedOperationException;
import me.github.fwfurtado.pickpay.external.ExternalIdentifier;
import me.github.fwfurtado.pickpay.usecases.transfer.TransferCommand;

import java.math.BigDecimal;

public class TransferCommandImpl extends TransferCommand {

    public TransferCommandImpl(Customer origin, Customer destiny) { super(origin, destiny); }

    public void transfer(BigDecimal amount) throws NotAllowedOperationException {
        this.origin.withdraw(amount);
        this.destiny.deposit(amount);
    }

}
