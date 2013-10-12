
//Abstract class Transaction represents an ATM transaction
public abstract class Transaction {
	//attributes
	private int accountNumber;
	private Screen screen = new Screen();
	private BankDatabase bankDatabase = new BankDatabase();
	
	//no-argument constructor invoked by subclasses using super()
	public Transaction(int accountNumber, Screen screen, BankDatabase bankDatabase){
		this.accountNumber = accountNumber;
		this.screen = screen;
		this.bankDatabase = bankDatabase;
	}
	
	//return account number
	public int getAccountNumber(){
		return accountNumber;
	}
	
	//return reference to screen
	public Screen getScreen(){
		return screen;
	}
	
	//return reference to bank database
	public BankDatabase getBankDatabase(){
		return bankDatabase;
	}
	
	//abstract method overridden by subclass
	public abstract void execute();
}
