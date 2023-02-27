//Pedro Nunez (pnunez14@toromail.csudh.edu)
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner Keyboard = new Scanner(System.in);
		
		int Userselect;
		do {
			Scanner Input = new Scanner(System.in);
			
			System.out.println("\n1 - Open a Checking Account\n2 - Open Saving Account\n3 - List Accounts\n4 - Account Statement");
			System.out.println("Please Enter Your choice:" );
			Userselect = Input.nextInt();
			
			
			switch(Userselect) {
			case 1:
				break;
			case 2:
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
				break;
				default:
					break;
				
			}
			
		}while(Userselect > 0||Userselect < 9);
		
		
	}

}
