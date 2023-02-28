//Pedro Nunez (pnunez14@toromail.csudh.edu)
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner Keyboard = new Scanner(System.in);
		try {
			
		int Userselect;
		do {
			Information person = new Information(null,null,null,0);
			Scanner Input = new Scanner(System.in);
			
			System.out.println("\n1 - Open a Checking Account\n2 - Open Saving Account\n3 - List Accounts\n4 - Account Statement\n"
					+ "5 - Deposit funds\n6 - Withdraw funds\n7 - Close an Account\n8 - Exit\n");
			System.out.println("Please Enter Your choice: ");
			Userselect = Input.nextInt();
			
			
			switch(Userselect) {
			case 1:
				System.out.print("Enter first name: ");
				person.setFirstname(Keyboard.nextLine());
				
				System.out.print("Enter last name: ");
				person.setLastname(Keyboard.nextLine());
				
				System.out.print("Enter social secuirty number: ");
				person.setSSN(Keyboard.nextLine());
				
				System.out.print("Enter overdraft limit: ");
				person.setOverdraft(Keyboard.nextInt());
				
				System.out.print("Thank you the account number is ");
				break;
			case 2:
				System.out.print("Enter first name: ");
				person.setFirstname(Keyboard.nextLine());
				
				System.out.print("Enter last name: ");
				person.setLastname(Keyboard.nextLine());
				
				System.out.print("Enter Social secuirty number: ");
				person.setSSN(Keyboard.nextLine());
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				System.exit(0);
				break;
				default:
					break;
				
			}
		
		
			
		}while(Userselect > 0||Userselect < 9);
		
	 }catch(InputMismatchException e) {
		 System.out.println("Please try again Characters aren't allowed for chosing your option. ");
	 }
		
	}

}
