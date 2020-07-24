package me.github.fwfurtado.pickpay.usecases.transfer;

import me.github.fwfurtado.pickpay.usecases.transfer.commands.TransferCommandImpl;

import java.math.BigDecimal;

public class TransferUseCase {

    public void transferVia(BigDecimal amount, TransferCommand command) {
        command.transfer(amount);
    }

}
