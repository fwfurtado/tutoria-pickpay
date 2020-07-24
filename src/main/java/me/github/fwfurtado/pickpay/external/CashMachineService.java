package me.github.fwfurtado.pickpay.external;

import java.math.BigDecimal;

import io.vavr.control.Try;

public interface CashMachineService {
    Try<ExternalIdentifier> tryWithDraw(BigDecimal amount, String walletCode);
}
