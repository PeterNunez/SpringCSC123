
public class person {

	private String firstname;
	private String lastname;
	private String email;
	private String SSN;
	
	
	public person(String firstname, String lastname, String email, String SSN) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.SSN = SSN;
	}


	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public String getEmail() {
		return email;
	}


	public String getSSN() {
		return SSN;
	}

	public String toString() {
		return firstname+":"+lastname+":"+email+":"+SSN;
	}
	
	

	
	
	
	
	
}
