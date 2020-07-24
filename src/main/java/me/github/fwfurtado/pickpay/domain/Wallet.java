package me.github.fwfurtado.pickpay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import me.github.fwfurtado.pickpay.exception.NotAllowedOperationException;
import me.github.fwfurtado.pickpay.utils.MathUtils;

public class Wallet {
	
	private String code;
    @Getter
    private BigDecimal balance = BigDecimal.ZERO;
    private List<Transaction> transactions = new ArrayList<>();

	public Wallet(String code) {
		this.code = code;
	}
    
    public void deposit(Transaction incoming) {
        transactions.add(incoming);
        balance = balance.add(incoming.getAmount());
    }
    
    public void withDraw(Transaction outcomming) throws NotAllowedOperationException {
    	transactions.add(outcomming);
    	if(MathUtils.isLessThan(this.balance, outcomming.getAmount()))
    		throw new NotAllowedOperationException("You do not have enough balance for this operation");
    		
    	balance = balance.subtract(outcomming.getAmount());
    }

    public Iterable<Transaction> getTransactions() {
        return transactions;
    }

	public String getCode() {
		return code;
	}

}
