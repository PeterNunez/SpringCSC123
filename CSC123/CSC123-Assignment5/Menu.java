//Pedro Nunez (pnunez14@toromail.csudh.edu)
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	InputStream in;
	OutputStream out;
	public Menu(InputStream in, OutputStream out) {
		this.in=in;
		this.out=out;
	}

	public static void main(String[] args) throws IOException, NoSuchAccountException, InsufficientBalanceException {
		new Menu(System.in,System.out);
		try {
			Scanner Keyboard = new Scanner(System.in);
		int Userselect;
		do {
			
			Scanner Input = new Scanner(System.in);
			
			System.out.println("\n1 - Open a Checking Account\n2 - Open Saving Account\n3 - List Accounts\n4 - Account Statement\n"
					+ "5 - Deposit funds\n6 - Withdraw funds\n7 - Close an Account\n8 - Save Transactions\n9 - Exit\n");
			System.out.print("Please Enter Your choice: ");
			Userselect = Input.nextInt();
			
			
			switch(Userselect) {
			case 1:
			 AccountInfo in = LocalBank.bankinterface(null, null, null, 0.0, "Checking", null);
				 
				System.out.print("\nEnter first name: ");
				in.getAccountHolder().setFirstname(Keyboard.nextLine());
				
				System.out.print("Enter last name: ");
				in.getAccountHolder().setLastname(Keyboard.nextLine());
				
				System.out.print("Enter social secuirty number: ");
				in.getAccountHolder().setSSN(Keyboard.nextLine());
				
				System.out.print("Enter overdraft limit: ");
				in.getAccountHolder().setOverdraft(Keyboard.nextDouble());
				
				System.out.print("\nThank you the account number is "+in.getAccountNumber()+"\n");
				//LocalBank.getstat(in.getAccountNumber(), "Open");
				break;
				
			case 2:

				AccountInfo in2 = LocalBank.bankinterface(null, null, null, 0.0, "Saving", null);

				System.out.print("\nEnter first name: ");
				in2.getAccountHolder().setFirstname(Keyboard.next());
			
				System.out.print("Enter last name: ");
				in2.getAccountHolder().setLastname(Keyboard.next());
			
				System.out.print("Enter social secuirty number: ");
				in2.getAccountHolder().setSSN(Keyboard.next());
			
				System.out.print("\nThank you the account number is "+in2.getAccountNumber()+"\n");
				//LocalBank.getstat(in2.getAccountNumber(), "Open");
				break;

			case 3:
				LocalBank.listAccounts();
				System.out.println("\n");
				break;
			case 4:		
				
				System.out.print("Enter account Number: ");
				int number = Keyboard.nextInt();

				if(LocalBank.search(number) == null){
					System.out.print("Account not found");
					break;
				}
				
				
				
				
				break;
			case 5:
				System.out.print("\nEnter account Number: ");
				int searchString = Keyboard.nextInt();

				if(LocalBank.search(searchString) == null){
					System.out.print("Account not found");
					break;
				}
				System.out.print("Enter the amount to deposit: ");
				double newD = Keyboard.nextDouble();
				try {
				LocalBank.deposit(searchString,newD);
				}catch(AccountClosedException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Deposit successful, the new balance is: $" + LocalBank.getBalance(searchString)+ "\n");
				break;

			case 6:
				System.out.print("\nEnter account Number: ");
				int numberAcc = Keyboard.nextInt();

				if(LocalBank.search(numberAcc) == null){
					System.out.print("Account not found");
					break;
				}
				System.out.print("Enter the amount to withdraw: ");
				double newWithdraw = Keyboard.nextDouble();
				try {
				LocalBank.withdraw(numberAcc, newWithdraw);
				}catch(AccountClosedException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Withdraw successful, the new balance is: $"+LocalBank.getBalance(numberAcc)+"\n");
				break;

			case 7:
				System.out.print("Enter amount number to close: ");
				int numbAcc = Keyboard.nextInt();

				if(LocalBank.search(numbAcc) == null){
					System.out.print("Account not found");
					break;
				}else{
					LocalBank.closeAccount(numbAcc);
					System.out.println("Account closed, current balance is "+LocalBank.search(numbAcc)+". Deposits are no longer possible");
				}
				break;
			case 8:
				
				break;
			case 9:
				System.exit(0);
				break;
				default:
					break;
				
			}
		
		
			
		}while(Userselect > 0|| Userselect < 10);
		
	 }catch(InputMismatchException e) {
		 System.out.println("Please try again Characters aren't allowed for chosing your option. ");
	 }
		
	}

}
