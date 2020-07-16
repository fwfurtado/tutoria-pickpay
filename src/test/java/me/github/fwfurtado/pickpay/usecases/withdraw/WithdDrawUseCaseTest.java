package me.github.fwfurtado.pickpay.usecases.withdraw;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.github.fwfurtado.pickpay.exception.NotAllowedOperationException;
import me.github.fwfurtado.pickpay.factory.CustomerFactory;
import me.github.fwfurtado.pickpay.factory.WalletFactory;

public class WithdDrawUseCaseTest {
	
	private CustomerFactory customerFactory;
	
	@BeforeEach
	void setup() {
		this.customerFactory = new CustomerFactory(new WalletFactory());
	}

    @Test
    public void shouldNotWithDraw() {
        var me = this.customerFactory.create("Fernando Furtado", "388.018.237-12", "fwfurtado@gmail.com");

        var amount = BigDecimal.valueOf(100);
        
        Assertions.assertThrows(NotAllowedOperationException.class, () -> me.withDraw(amount));
    }

}
