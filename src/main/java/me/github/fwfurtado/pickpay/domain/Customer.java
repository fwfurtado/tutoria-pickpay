package me.github.fwfurtado.pickpay.domain;

import lombok.Getter;
import me.github.fwfurtado.pickpay.exception.NotAllowedOperationException;

import java.math.BigDecimal;

public class Customer {
    @Getter
    private String name;
    @Getter
    private String socialNumber;
    @Getter
    private String email;
    private CreditCard creditCard;
    private Wallet wallet;
    
    public Customer(String name, String socialNumber, String email, Wallet wallet) {
        this.name = name;
        this.socialNumber = socialNumber;
        this.email = email;
        this.wallet = wallet;
    }

    public void linkCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void deposit(BigDecimal amount) {
        wallet.deposit(Transaction.incoming(amount));
    }

    public void withDraw(BigDecimal amount) throws NotAllowedOperationException {
    	wallet.withDraw(Transaction.outcoming(amount));
    }

    public BigDecimal getBalance() {
        return wallet.getBalance();
    }

    public Iterable<Transaction> getTransactions() {
        return wallet.getTransactions();
    }

    public CreditCard getCardCredit() {
        return creditCard;
    }
    
    public String getWalletCode() {
    	return this.wallet.getCode();
    }
    
}
