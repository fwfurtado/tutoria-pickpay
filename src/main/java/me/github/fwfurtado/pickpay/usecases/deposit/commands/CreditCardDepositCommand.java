package me.github.fwfurtado.pickpay.usecases.deposit.commands;

import me.github.fwfurtado.pickpay.domain.Customer;
import me.github.fwfurtado.pickpay.external.CreditCardService;
import me.github.fwfurtado.pickpay.usecases.deposit.DepositCommand;

import java.math.BigDecimal;

public class CreditCardDepositCommand extends DepositCommand {
    private final CreditCardService creditCardService;

    public CreditCardDepositCommand(Customer customer, CreditCardService creditCardService) {
        super(customer);
        this.creditCardService = creditCardService;
    }

    @Override
    public void deposit(BigDecimal amount) {
        var cardCredit = customer.getCardCredit();

        creditCardService
                .tryBilling(amount, cardCredit)
                .onSuccess(externalIdentifier -> customer.deposit(amount));
    }
}
