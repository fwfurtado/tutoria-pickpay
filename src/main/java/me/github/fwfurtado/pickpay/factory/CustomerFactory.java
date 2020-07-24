package me.github.fwfurtado.pickpay.factory;

import me.github.fwfurtado.pickpay.domain.Customer;
import me.github.fwfurtado.pickpay.domain.Wallet;

public class CustomerFactory {
	
	private WalletFactory walletFactory;
	
	public CustomerFactory(WalletFactory walletFactory) {
		this.walletFactory = walletFactory;
	}

	public Customer create(String name, String socialNumber, String email) {
		Wallet wallet = this.walletFactory.create();
		return new Customer(name, socialNumber, email, wallet);
	}
}
