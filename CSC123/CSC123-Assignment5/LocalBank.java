//Pedro Nunez (pnunez14@toromail.csudh.edu)
import java.util.ArrayList;

public class LocalBank {

	private static ArrayList<AccountInfo> listing = new ArrayList<AccountInfo>();
	private static int accountcounter = 1;
	private static int transactionCounter = 1;
	
	private LocalBank() throws AccountClosedException {}
	
	public static AccountInfo bankinterface(String firstname, String lastname, String SSN, double Overdraft, String accountType, String type) {

		Information person = new Information(firstname, lastname, SSN, Overdraft);
		AccountInfo in = new AccountInfo(accountcounter++, person, accountType, transactionCounter++,type);
		
		listing.add(in);
		return in;
	}

	

	public static void printstatment(int accNumber) {
		for(AccountInfo in:listing) {
			if(accNumber == in.getAccountNumber()){
				//System.out.print(in.getTransactionID()+" : "+in.getType()+" : "+in.getBalance());
				in.Statment();
			}
			
		}
		
	}
	
	public static void listAccounts() {
		for(AccountInfo as: listing) {
			System.out.println(as);
		}
	}

	public static String search(int accountNum) {

        for(AccountInfo r: listing) {
            if(accountNum == r.getAccountNumber()) return "Closed";
            
        }

        return null;
	}

	public static boolean deposit(int accountNumber, double amount) throws AccountClosedException {

		
		for(AccountInfo in: listing)
			try {
		if(amount < 0 || in.isAccountOpen()== "closed") return false;
		else{
			if(in.getAccountNumber() == accountNumber){
			in.setBalance(in.getBalance() + amount);
			in.deposit(amount);
			}
		}
		}catch(AccountClosedException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	public static boolean withdraw(int accountNum, double amount) throws AccountClosedException {
		
		for(AccountInfo in: listing)
		if(in.getBalance() - amount < 0 || in.isAccountOpen() == "closed") return false;
		else { 
			if(in.getAccountNumber() == accountNum){
				in.setBalance(in.getBalance() - amount);
				in.withdraw(amount);
			}
		} 
		
		return true;
	}

	public static double find(int accountNum) {

        for(AccountInfo in: listing) {
            if(in.getAccountNumber() == accountNum) return in.getBalance();
        }

        return 0;

    }

	public static AccountInfo getstat(int accNumber, String Closed) {

		for(AccountInfo in: listing) {
			if(accNumber == in.getAccountNumber()){
				in.setAccountOpen(Closed);
				
			}
			
		}
		return null;

	}

	public static String setStatus(int accNumber) {

		for(AccountInfo in: listing) {
			if(accNumber == in.getAccountNumber()) {
				return in.isAccountOpen();

			}
		}

		return null;
	}
}
