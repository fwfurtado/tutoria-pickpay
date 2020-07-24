package me.github.fwfurtado.pickpay.domain;

import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class Transaction {
    private BigDecimal amount;
    private LocalDateTime date;
    private TransactionType type;

    public Transaction(BigDecimal amount, LocalDateTime date, TransactionType type) {
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public static Transaction incoming(BigDecimal amount) {
        return new Transaction(amount, LocalDateTime.now(), TransactionType.INCOMING);
    }

    public static Transaction outcoming(BigDecimal amount) {
        return new Transaction(amount, LocalDateTime.now(), TransactionType.OUTCOMING);
    }
}
