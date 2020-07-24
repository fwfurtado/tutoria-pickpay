package me.github.fwfurtado.pickpay.utils;

import java.math.BigDecimal;

public class MathUtils {
	
	public static boolean isLessThan(BigDecimal current, BigDecimal value) {
		int comparation = current.compareTo(value);
		return comparation == -1;
	}
	
}
