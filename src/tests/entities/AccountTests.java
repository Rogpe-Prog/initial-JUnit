package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.Factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.Deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void DepositShouldDoNothingWhenNegativeAmount() {
		
		double expectedValue = 100.0;

		Account acc = AccountFactory.createAccount(expectedValue);
		
		double amount = -200.0;
		
		acc.Deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void FullWithdrawShouldClearBalance() {
		
		double expectedValue  = 0.0;
		double initialBalance = 800.0;
		
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.FullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
		
	}
	
	@Test
	public void WithdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.Withdraw(500.0);
		
		Assertions.assertEquals(300.0, acc.getBalance());
		
	}
	
	@Test
	public void withgrawShouldThrowExceptionWhenInsufficientBalance() {
				
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.Withdraw(801.0);
		});
		
	}
	
	
	

}
