//Pedro Nunez (pnunez14@toromail.csudh.edu)
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class AccountInfo {

	private int accountNumber;
	private Information accountHolder;
	private double balance;
	private String accountType;
	private String type;
	private ArrayList<Transaction> transaction;
	private boolean open=true;
	
	public AccountInfo(int accountNumber, Information accountHolder, String accountType, String type) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.accountType = accountType;
		this.type = type;
		transaction = new ArrayList<Transaction>();
		
	}

	public void deposit(double amount) throws AccountClosedException{
		double value=getBalance();
		if(!isAccountOpen()&&value>=0) {
			throw new AccountClosedException("\nYour account is closed and your're unable to deposit or withdraw more than what is left in your account\n");
		}
		transaction.add(new Transaction(Transaction.credit,amount));
	}

	public void withdraw(double amount) throws InsufficientBalanceException{
		double value=getBalance();
		
		if(!isAccountOpen()&&value<=0) {
			throw new InsufficientBalanceException("\nThe account is closed and balance is: "+value+"\n\n");
		}
		transaction.add(new Transaction(Transaction.debt,amount));
	}
	

	public void closeAccount() {
		open = false;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Information getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		double newBalance = 0;
		
		for(Transaction okay: transaction) {
			if(okay.getType()==Transaction.credit)newBalance+= okay.getNewamount();
			else newBalance-= okay.getNewamount();
		}
		return newBalance;
	}

	public boolean isAccountOpen() {
		return open;
	}


	public String getAccountType() {
		return accountType;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		return accountNumber+" ("+accountType+") "+getAccountHolder().getFirstname()+" : "+getAccountHolder().getLastname()+" : "+getAccountHolder().getSSN()+" :  $"+balance+" : "+isAccountOpen();
	}
	
	public void printTransactions(OutputStream out) throws IOException {
		
		out.write("\n\n".getBytes());
		out.write("------------------\n".getBytes());
	
		for(Transaction t: transaction) {
			out.write(t.toString().getBytes());
			out.write((byte)10);
		}
		out.write("------------------\n".getBytes());
		out.write(("Balance: "+getBalance()+"\n\n\n").getBytes());
		out.flush();
		
	}
}
