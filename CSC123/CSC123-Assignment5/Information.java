//Pedro Nunez (pnunez14@toromail.csudh.edu)
public class Information {

	private String firstname;
	private String lastname;
	private String SSN;
	private double Overdraft;
	
	public Information(String firstname, String lastname, String SSN, double Overdraft) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.SSN = SSN;
		this.Overdraft = Overdraft;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getSSN() {
		return SSN;
	}

	public double getOverdraft() {
		return Overdraft;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}

	public void setOverdraft(double Overdraft) {
		this.Overdraft = Overdraft;
	}
	
	public String toString () {
		return firstname+" "+lastname+" "+SSN+" "+Overdraft;
	}
	
	
	
	
	
	
}
