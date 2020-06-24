package me.github.fwfurtado.pickpay.usecases.deposit;

import java.math.BigDecimal;

public class DepositUseCase {

    public void depositVia(BigDecimal amount, DepositCommand command) {
        command.deposit(amount);
    }

}
