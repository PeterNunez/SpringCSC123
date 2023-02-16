
public class Test {

	public static void main(String[] args) {
		
		person per = new person("Pedro" , "Nunez" , "something@gmail.com" , "999-999-9999");
		Account myChecking = new Account(100, per, "Checking");
		
		System.out.println(per);
	}
}
