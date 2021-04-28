import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	public static int numberOfAccounts = 0;
	public static double totalInAccounts = 0;
	
	public BankAccount() {
		
	} 
	
	
	public static int accountCount() {
        return numberOfAccounts;
    }
	
	public static double accountsTotalSum() {
		return totalInAccounts;
	}
	
	private static String accountNumberGenerator() {
		String string = "";
		Random rando = new Random();
		for(int i = 0; i < 10; i++) {
			string += rando.nextInt(10);
		}
		return string;
	}
	

	public BankAccount(String fName, String lName) {
		String firstName = fName;
		String lastName = lName;
		this.accountNumber = BankAccount.accountNumberGenerator();
		this.checkingBalance = 0;
		this.savingsBalance = 0;
		
		numberOfAccounts++;
	}
	
	public void makeDeposit(double amount, double account) {
		if(account == this.checkingBalance) {
			this.checkingBalance += amount;
			
		} else this.savingsBalance += amount;
		
		totalInAccounts += amount;

	}
	
	public void makeWithdrawl(double amount, double account) {
		
			if(account == this.checkingBalance && this.checkingBalance < amount) {
				System.out.println("Sorry, insufficient funds.");
			} else if(account == this.checkingBalance) {
				this.checkingBalance -= amount;
				totalInAccounts -= amount;
			}
			
			if(account == this.savingsBalance && this.savingsBalance < amount) {
				System.out.println("Sorry, insufficient funds.");
			} else if(account == this.savingsBalance) {
				this.savingsBalance -= amount;
				totalInAccounts -= amount;
			}		
	}
	
	public double balanceForAllAccounts() {
		return this.getCheckingBalance() + this.getSavingsBalance();
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
		
}
