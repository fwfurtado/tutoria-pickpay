package me.github.fwfurtado.pickpay.usecases.deposit;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.github.fwfurtado.pickpay.factory.CustomerFactory;
import me.github.fwfurtado.pickpay.factory.WalletFactory;

public class DepositUseCaseTest {
	
	private CustomerFactory customerFactory;
	
	@BeforeEach
	void setup() {
		this.customerFactory = new CustomerFactory(new WalletFactory());
	}

    @Test
    public void shouldDeposit100() {
        var me = this.customerFactory.create("Fernando Furtado", "388.018.237-12", "fwfurtado@gmail.com");

        var newBalance = BigDecimal.valueOf(100);
        me.deposit(newBalance);

        me.getTransactions();

        Assertions.assertEquals(newBalance, me.getBalance());
    }

}
