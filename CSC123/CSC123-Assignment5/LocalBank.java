//Pedro Nunez (pnunez14@toromail.csudh.edu)
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;


public class LocalBank {

	private static Map<Integer, AccountInfo> listing = new TreeMap<Integer, AccountInfo>();
	private static int accountcounter = 1;
	private static int transactionCounter = 1;
	
	private LocalBank() throws AccountClosedException {}
	
	public static AccountInfo bankinterface(String firstname, String lastname, String SSN, double Overdraft, String accountType, String type) {

		Information person = new Information(firstname, lastname, SSN, Overdraft);
		AccountInfo in = new AccountInfo(accountcounter++, person, accountType, type);
		
		listing.put(in.getAccountNumber(), in);
		return in;
	}

	

	/*public static void printstatment(int accNumber) {
		for(AccountInfo in:listing) {
			if(accNumber == in.getAccountNumber()){
				in.Statment();
			}
			
		}
		
	}*/
	
	public static void listAccounts() {
		
		Collection<AccountInfo> things= listing.values();
		
		for (AccountInfo e:things) {
			System.out.println(e);
		}
	}
	
	public static void printAccountTransactions(int accountNumber, OutputStream out) throws IOException,NoSuchAccountException{
		
		search(accountNumber).printTransactions(out);
	}

	public static AccountInfo search(int accountNum) throws NoSuchAccountException{

        
            if(!listing.containsKey(accountNum)) {
            	throw new NoSuchAccountException("\nAccount Number: "+accountNum+" not found!\n ");
            }

        return listing.get(accountNum);
	}
	
	public static AccountInfo exist(int accountNum) throws NoSuchAccountException {
		
			if(listing.containsKey(accountNum)) {
				throw new NoSuchAccountException("\nAccount Number: "+accountNum+" not found!\n");
			}
			
		return listing.get(accountNum);
	}

	public static void deposit(int accountNumber, double amount) throws AccountClosedException, NoSuchAccountException {

		search(accountNumber).deposit(amount);
		
	}

	public static void withdraw(int accountNum, double amount) throws AccountClosedException, InsufficientBalanceException, NoSuchAccountException {
		
		search(accountNum).withdraw(amount);
	}
	
	public static double getBalance(int accountNumber) throws NoSuchAccountException {
		return search(accountNumber).getBalance();
	}
	
	public static void closeAccount(int accountNumber) throws NoSuchAccountException {
		search(accountNumber).closeAccount();
	}

	/*public static double find(int accountNum) {

        for(AccountInfo in: listing) {
            if(in.getAccountNumber() == accountNum) return in.getBalance();
        }

        return 0;

    }*/
}
