package me.github.fwfurtado.pickpay.external;

import io.vavr.control.Try;
import me.github.fwfurtado.pickpay.domain.CreditCard;

import java.math.BigDecimal;

public interface CreditCardService {
    Try<ExternalIdentifier> tryBilling(BigDecimal amount, CreditCard cardCredit);
}
