
public class Test {

	public static void main(String[] args) {
		
		//person per = new person("Pedro" , "Nunez" , "something@gmail.com" , "999-999-9999");
		//Account myChecking = new Account(100, per, "Checking");
		
		//System.out.println(myChecking);
		
		Account myaccount = Bank.openAccount("Pedro", "Nunez", "Something@gmail.com", "999-999-9999", "Checking");
		
		System.out.println(myaccount);

	}
}
