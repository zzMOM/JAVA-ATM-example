	

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
	public Withdrawal(int accountNumber, Screen screen, BankDatabase bankDatabase){
		super(accountNumber, screen, bankDatabase);
	}
	
	//operation
	public void execute(){
		//create cash dispenser
		cashDispenser = new CashDispenser();
		keypad = new Keypad();
		
		//screen display withdrawal menu
		super.getScreen().displayWithdrawalMenu();
		
		//keypad enter choice
		int choice = keypad.getInput();
		
		//Five chances for the user to enter correct amount
		for(int i = 0; i < 5; i++){
			//choice value to amount
			switch(choice){
			case 1: amount = 20;
			case 2: amount = 40;
			case 3: amount = 60;
			case 4: amount = 100;
			case 5: amount = 200;
			case 6: break;
			default: break;
			}
			//check available cash in cash dispenser
			if(!cashDispenser.isSufficientCashAvailable(amount)){
				super.getScreen().insufficientCashMessage();
				break;
			}
			
			//check available amount in account
			if(super.getBankDatabase().getAvailabeBalance(super.getAccountNumber()) >= amount){
				//reminder user to get cash from cash dispenser
				super.getScreen().takeCashMessage();
				//credit from account
				int num = super.getAccountNumber();
				super.getBankDatabase().credit(num, amount);
			} else {
				super.getScreen().accountBalanceErrorMessage();
				
				//screen display withdrawal menu
				super.getScreen().displayWithdrawalMenu();
				
				//keypad enter choice
				choice = keypad.getInput();
			}
		}
	}
	
}
