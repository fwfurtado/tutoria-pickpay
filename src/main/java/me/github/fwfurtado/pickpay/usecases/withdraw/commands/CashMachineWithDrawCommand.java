package me.github.fwfurtado.pickpay.usecases.withdraw.commands;

import java.math.BigDecimal;

import me.github.fwfurtado.pickpay.domain.Customer;
import me.github.fwfurtado.pickpay.external.CashMachineService;
import me.github.fwfurtado.pickpay.usecases.withdraw.WithDrawCommand;

public class CashMachineWithDrawCommand extends WithDrawCommand {
    
	private final CashMachineService cashMachineService;

    public CashMachineWithDrawCommand(Customer customer, CashMachineService cashMachineService) {
        super(customer);
        this.cashMachineService = cashMachineService;
    }

	@Override
	public void withDraw(BigDecimal amount) {
		String walletCode = customer.getWalletCode();
		
		this.cashMachineService
			.tryWithDraw(amount, walletCode)
			.andThenTry(transactionId -> customer.withDraw(amount))
			.onSuccess(transactionId -> System.out.println("Saque realizado com sucesso"));
	}


}
