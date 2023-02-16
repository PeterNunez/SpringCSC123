import java.util.ArrayList;

public class Bank {

	//fields
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static int accountCounter = 1;
	
	private Bank() {}
	
	//methods
	public static Account openAccount(String firstname , String lastname , String email , String SSN, String accountType) {
		
		person p = new person(firstname, lastname, email, SSN);
		Account a = new Account(accountCounter++, p, accountType);
		accounts.add(a);
		return a;
	}
	
	public static void listAccounts() {
		for(Account as: accounts) {
			System.out.println(as);
		}
	}
}
