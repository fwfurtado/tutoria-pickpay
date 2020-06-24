package me.github.fwfurtado.pickpay.usecases;

import me.github.fwfurtado.pickpay.domain.Customer;
import me.github.fwfurtado.pickpay.domain.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DepositUseCaseTest {


    @Test
    public void shouldDeposit100() {
        var me = new Customer("Fernando Furtado", "388.018.237-12", "fwfurtado@gmail.com");

        var newBalance = BigDecimal.valueOf(100);
        me.deposit(newBalance);

        me.getTransactions();

        Assertions.assertEquals(newBalance, me.getBalance());
    }

}
