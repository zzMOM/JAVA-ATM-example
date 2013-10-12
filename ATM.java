

public class ATM {
	
	//references to associated objects
	private Screen screen;
	private Keypad keypad;
	private BankDatabase bankDatabase;
	private BalanceInquiry balanceInquiry;
	private Withdrawal withdrawal;
	private Deposit deposit;
	private boolean userAuthenticated = false;
	
	//no-argument constructor
	public ATM(){
		
	}
	

	//operations
	public void excute(){
		screen = new Screen();
		int accountNumber, pin;
		double amount;
		
		//create new keypad object
		keypad = new Keypad();
		
		//build bank database and create account records for database
		bankDatabase = new BankDatabase();
		bankDatabase.createBankDatabase();
		
				
		while(true){
			//ATM screen display weclcome message.
			screen.displayWelcome();
			
			//ATM wait user to input from keypad ( user keyboard instead)
			accountNumber = keypad.getInput();
			
			//check account number
			if(bankDatabase.authenticateUser(accountNumber)){
				//authenticate user then input PIN
				screen.pinMessage();
				
				//user has three time to enter validate pin
				for (int i = 0; i < 3; i++){
					//keypad enter PIN
					pin = keypad.getInput();
					
					//validate pin
					if(bankDatabase.validatePIN(accountNumber, pin)){
						//validate pin then go to main menu
						screen.displayMainMenu();
						
						//keypad enter choice, screen show different menu
						int choice = keypad.getInput();
						
						switch(choice){
							case 1: balanceAction(accountNumber);//view account balance
									break;
							case 2: withdrawalAction(accountNumber);//withdrawal cash
									break;
							case 3: depositAction(accountNumber);//deposit funds
									break;
							case 4: break;//exit
							default: break;//any other keys to exit
						}
						
					} else {
						//screen displays pin error message and ask user to enter PIN
						screen.pinErrorMessage();
						screen.pinMessage();
					}
				}
			} else {//wrong account number
				//show account error message, go to welcome menu
				screen.accountErrorMessage();
			}
		} 
	}

	public void balanceAction(int accountNumber){
		balanceInquiry = new BalanceInquiry(accountNumber, screen, bankDatabase);
		balanceInquiry.execute();
		
		
	}
	
	public void withdrawalAction(int accountNumber){
		double amount = 0;
		
		//create cash dispenser
		CashDispenser cashDispenser = new CashDispenser();
		
		//screen display withdrawal menu
		screen.displayWithdrawalMenu();
		
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
			withdrawal = new Withdrawal(accountNumber, screen, bankDatabase, amount);
			
			//check availabe cash in cash dispenser
			if(!cashDispenser.isSufficientCashAvailable(amount)){
				screen.insufficientCashMessage();
				break;
			}
			
			//check available amount in account
			if(bankDatabase.getAvailabeBalance(accountNumber) >= amount){
				withdrawal.execute();
			} else {
				screen.accountBalanceErrorMessage();
			}
		}
		
	}
	
	public void depositAction(int accountNumber){
		//create deposit slot
		DepositSlot depositSlot = new DepositSlot();
		deposit = new Deposit();
		deposit.execute();
	}
	
}
