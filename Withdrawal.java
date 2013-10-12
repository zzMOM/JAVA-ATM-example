	

/**
 * class Withdrawal represents an ATM withdrawal transaction
 * @author weiwu
 *
 */
public class Withdrawal extends Transaction{
	//attribute
	private double amount;
	//references to associated objects
	private Keypad keypad;//ATM's keypad
	private CashDispenser cashDispenser;//ATM's cash dispenser
	
	//no-argument constructor
	public Withdrawal(int accountNumber, Screen screen, BankDatabase bankDatabase, double amount){
		super(accountNumber, screen, bankDatabase);
		this.amount = amount;
	}
	
	//operation
	public void execute(){
		
	}
}
