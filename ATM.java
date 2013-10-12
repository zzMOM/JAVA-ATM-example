

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
							case 1: BalanceInquiry bi = new BalanceInquiry(accountNumber, screen, bankDatabase);//view account balance
									bi.execute();
									break;
							case 2: Withdrawal w = new Withdrawal(accountNumber, screen, bankDatabase, amount);;//withdrawal cash
									w.execute();
									break;
							case 3: Deposit d =  new Deposit(accountNumber, screen, bankDatabase, amount);//deposit funds
									d.excute();
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

}
