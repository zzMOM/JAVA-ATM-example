
public class Deposit extends Transaction{
	//attributes
	private double amount;
	//references to associated objects
	private Keypad keypad;
	private DepositSlot depositSlot;
	
	//no-argument constructor
	public Deposit(int accountNumber, Screen screen, BankDatabase bankDatabase){
		super(accountNumber, screen, bankDatabase);
		this.amount = amount;
		
	}
	
	//operations
	public void execute(){
		//create deposit slot
		DepositSlot depositSlot = new DepositSlot();
		keypad = new Keypad();
		
		//screen display deposit menu
		super.getScreen().displayDepositMenu();
		
		//keypad enter choice
		int choice = keypad.getInput();
		
			//user enter amount
			if(choice > 0){
				amount = choice;
			} else {
				return;
			}
					
			//update total amount
			int accountNumber = super.getAccountNumber();
			double currentTotalBalance = super.getBankDatabase().getTotalBalance(accountNumber) ;
			super.getBankDatabase().debit(accountNumber, currentTotalBalance + amount);
			//screen display withdrawal menu
			super.getScreen().displayDepositMenu();
			
			//keypad enter choice
			choice = keypad.getInput();
			}
	}

