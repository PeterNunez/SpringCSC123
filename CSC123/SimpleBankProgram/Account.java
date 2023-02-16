
public class Account {

	private int accountnumber;
	private person accountHolder;
	private double balance;
	private boolean accountOpen;
	private String accountType;
	
	//Constructor
	public Account(int accountnumber, person accountHolder, String accountType) {
		super();
		this.accountnumber = accountnumber;
		this.accountHolder = accountHolder;
		this.accountType = accountType;
		this.accountOpen = true;
	}
	
	//methods
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
	
	//public void

	public int getAccountnumber() {
		return accountnumber;
	}

	public person getAccountHolder() {
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
		return accountnumber+"("+accountType+")"+accountOpen+":"+balance+":"+accountHolder;
	}
	
	
	
	
	
}
