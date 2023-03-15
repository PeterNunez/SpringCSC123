
import java.util.ArrayList;


//Pedro Nunez (pnunez14@toromail.csudh.edu)
public class AccountInfo {

	private int accountNumber;
	private Information accountHolder;
	private double balance;
	private String accountOpen;
	private String accountType;
	private int TransactionID;
	private String type;
	private ArrayList<String> transaction = new ArrayList<String>();
	
	public AccountInfo(int accountNumber, Information accountHolder, String accountType, int TransactionID, String type) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.accountOpen = "Open";
		this.accountType = accountType;
		this.TransactionID = TransactionID;
		this.type = type;
		
	}

	public void Statment() {
		for(String a:transaction) {
			System.out.println(a);
		}
		System.out.print("\nBalance: $"+balance);
	}

	public void deposit(double amount) {
		type = String.format("%d : Credit : %.2f", TransactionID++, amount);
		transaction.add(type);
	}

	public void withdraw(double amount) {
		type = String.format("%d : Debit  : %.2f",TransactionID++, amount);
		transaction.add(type);
	}
	

	public void closeAccount() {
		this.accountOpen="Closed";
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

	public String isAccountOpen() {
		return this.accountOpen;
	}

	public void setAccountOpen(String accountOpen) {
		this.accountOpen = accountOpen;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		return accountNumber+" ("+accountType+") "+getAccountHolder().getFirstname()+" : "+getAccountHolder().getLastname()+" : "+getAccountHolder().getSSN()+" :  $"+balance+" : "+accountOpen;
	}
}
