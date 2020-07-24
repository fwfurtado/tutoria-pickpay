package me.github.fwfurtado.pickpay.usecases.deposit.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.vavr.control.Try;
import me.github.fwfurtado.pickpay.domain.CreditCard;
import me.github.fwfurtado.pickpay.domain.Customer;
import me.github.fwfurtado.pickpay.external.CreditCardService;
import me.github.fwfurtado.pickpay.factory.CustomerFactory;
import me.github.fwfurtado.pickpay.factory.WalletFactory;

@ExtendWith(MockitoExtension.class)
class CreditCardDepositCommandTest {
    private Customer customer;

    @Mock
    private CreditCardService creditCardService;
    private CreditCardDepositCommand depositCommand;
    private CustomerFactory customerFactory;
    @BeforeEach
    void setup() {
    	this.customerFactory = new CustomerFactory(new WalletFactory());
        customer = this.customerFactory.create("Fernando Furtado", "388.018.237-12", "fwfurtado@gmail.com");

        var creditCard = new CreditCard("Fernando Furtado", "1234432178900987", 874, YearMonth.now().plusYears(2));

        customer.linkCreditCard(creditCard);
        depositCommand = new CreditCardDepositCommand(customer, creditCardService);
    }

    @Test
    void shouldDepositViaCreditCardTheAmountOf100() {
        var amount = BigDecimal.valueOf(100);

        given(creditCardService.tryBilling(eq(amount), any(CreditCard.class))).willReturn(Try.success(UUID::randomUUID));

        depositCommand.deposit(amount);

        then(creditCardService).should(only()).tryBilling(amount, customer.getCardCredit());

        assertEquals(amount, customer.getBalance());
    }

    @Test
    void shouldNotDepositWhenTheCreditCardServicesFail() {
        given(creditCardService.tryBilling(any(BigDecimal.class), any(CreditCard.class)))
                .willReturn(Try.failure(new IllegalStateException("Cannot billing the credit card")));


        var amount = BigDecimal.valueOf(100);
        depositCommand.deposit(amount);

        then(creditCardService).should(only()).tryBilling(amount, customer.getCardCredit());

        assertEquals(BigDecimal.ZERO, customer.getBalance());
    }
}