	

/**
 * class Withdrawal represents an ATM withdrawal transaction
 * @author weiwu
 *
 */
public class Withdrawal {
	//attribute
	private int accountNumber;
	private double amount;
	
	//references to associated objects
	private Screen screen;//ATM's screen
	private Keypad keypad;//ATM's keypad
	private CashDispenser cashDispenser;//ATM's cash dispenser
	private BankDatabase bankDatabase;//account info database
	
	//no-argument constructor
	public Withdrawal(){
		
	}
	
	//operation
	public void execute(){
		
	}
}
