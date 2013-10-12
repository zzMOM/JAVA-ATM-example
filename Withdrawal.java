	

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
	public Withdrawal(){
		
	}
	
	//operation
	public void execute(){
		
	}
}
