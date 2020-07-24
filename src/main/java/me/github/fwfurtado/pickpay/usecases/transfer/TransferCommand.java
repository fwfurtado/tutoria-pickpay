package me.github.fwfurtado.pickpay.usecases.transfer;

import io.vavr.control.Try;
import me.github.fwfurtado.pickpay.domain.Customer;
import me.github.fwfurtado.pickpay.exception.NotAllowedOperationException;
import me.github.fwfurtado.pickpay.external.ExternalIdentifier;

import java.math.BigDecimal;

public abstract class TransferCommand {

    protected final Customer origin;
    protected final Customer destiny;

    public TransferCommand(Customer origin, Customer destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public abstract void transfer(BigDecimal amount) throws NotAllowedOperationException;

}
