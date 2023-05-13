//Pedro Nunez (pnunez14@toromail.csudh.edu)
public class Transaction {

	public static final char credit='C';
	public static final char debt='D';
	double newamount;
	int transactionID;
	char type;
	
	
	public Transaction(char type, double newamount) {
		this.newamount= newamount;
		this.type=type;
	}

	public double getNewamount() {
		return newamount;
	}

	public char getType() {
		return type;
	}
	
	public String toString() {
		return (this.transactionID+":"+(type==this.credit?"Deposit":"Withdrawal")+"\t: "+newamount);
		
	}
	
	
}
