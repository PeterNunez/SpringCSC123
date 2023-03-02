import java.util.ArrayList;

public class LocalBank {

	private static ArrayList<AccountInfo> listing = new ArrayList<AccountInfo>();
	private static int accountcounter = 1;
	
	private LocalBank() {}
	
	public static AccountInfo bankinterface(int accountNumber, Information accountHolder, String accountType) {
		
		AccountInfo in = new AccountInfo(accountcounter++, accountHolder, accountType);
		listing.add(in);
		return in;
	}
	
	public static void listAccounts() {
		for(AccountInfo as: listing) {
			System.out.println(as);
		}
	}
}
