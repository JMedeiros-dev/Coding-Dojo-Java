
public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount account1 = new BankAccount("Julia", "Roberts");
		BankAccount account2 = new BankAccount("Axel", "Rose");
		System.out.println("Julia's acccount number: " + account1.getAccountNumber());
		System.out.println("Total number of Accounts in bank: " + BankAccount.accountCount());
		account1.makeDeposit(25.00, account1.getCheckingBalance());
		System.out.println("Total for Julia'a acccount: " + account1.getCheckingBalance());
		System.out.println("Total Balance in bank equals: "+ BankAccount.totalInAccounts);
		account1.makeWithdrawl(15.00, account1.getCheckingBalance());
		System.out.println("Total for Julia'a acccount: " + account1.getCheckingBalance());
		System.out.println("Total Balance in bank equals: " + BankAccount.totalInAccounts);
		account2.makeDeposit(100.00, account2.getCheckingBalance());
		account2.makeDeposit(200.00, account2.getSavingsBalance());
		System.out.println("Total Balance in bank equals: " + BankAccount.totalInAccounts);
		System.out.println("Total for Axel's account: " + account2.balanceForAllAccounts());
		BankAccount account3 = new BankAccount("Jackie", "Chan");
		System.out.println("Jackie's acccount number: " + account3.getAccountNumber());
		System.out.println("Total number of Accounts in bank: " + BankAccount.accountCount());
		BankAccount account4 = new BankAccount("Steve", "Austin");
		System.out.println("Steve's acccount number: " + account4.getAccountNumber());
	}
}
