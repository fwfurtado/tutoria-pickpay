package me.github.fwfurtado.pickpay.usecases.withdraw;

import java.math.BigDecimal;

public class WithDrawtUseCase {

    public void withDraw(BigDecimal amount, WithDrawCommand command) {
        command.withDraw(amount);
    }

}
