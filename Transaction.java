
//Abstract class Transaction represents an ATM transaction
public abstract class Transaction {
	//attributes
	private int accountNumber;
	private Screen screen;
	private BankDatabase bankDatabase;
	
	//no-argument constructor invoked by subclasses using super()
	public Transaction(){
		
	}
	
	/*/return account number
	public int getAccountNumber(){
		
	}
	
	//return reference to screen
	public Screen getScreen(){
		
	}
	
	//return reference to bank database
	public BankDatabase getBankDatabase(){
		
	}*/
	
	//abstract method overridden by subclass
	public abstract void execute();
}
