package me.github.fwfurtado.pickpay.factory;

import java.util.UUID;

import me.github.fwfurtado.pickpay.domain.Wallet;

public class WalletFactory {
	
	public Wallet create() {
		return new Wallet(UUID.randomUUID().toString());
	}
	
}
