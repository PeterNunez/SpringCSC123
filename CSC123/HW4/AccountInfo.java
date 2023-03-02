//Pedro Nunez (pnunez14@toromail.csudh.edu)
public class AccountInfo {

	private int accountNumber;
	private Information accountHolder;
	private double balance;
	private boolean accountOpen;
	private String accountType;
	
	public AccountInfo(int accountNumber, Information accountHolder, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.accountOpen = true;
		this.accountType = accountType;
	}
	
	public boolean deposit(double amount) {
		if(amount < 0|| accountOpen == false) return false;
		balance = balance+amount;
		return true;
	}
	
	public boolean withdraw(double amount) {
		
		if(balance - amount < 0) return false;
		balance=balance-amount;
		return true;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Information getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public boolean isAccountOpen() {
		return accountOpen;
	}

	public String getAccountType() {
		return accountType;
	}
	
	public String toString() {
		return accountNumber+"("+accountType+")"+accountOpen+":"+balance+":"+accountHolder;
	}
}
