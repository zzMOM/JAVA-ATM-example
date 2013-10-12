

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
		double amount = 0;
		
		//create new keypad object
		keypad = new Keypad();
		
		//build bank database and create account records for database
		bankDatabase = new BankDatabase();
		bankDatabase.createBankDatabase();
		
				
		while(true){//------------------------------------------------------welcome menu
			//ATM screen display welcome message.
			screen.displayWelcome();
			
			//ATM wait user to input from keypad ( user keyboard instead)
			accountNumber = keypad.getInput();
			
			//check account number
			if(bankDatabase.authenticateUser(accountNumber)){
				//authenticate user then input PIN
				screen.pinMessage();
				
				//if user choice exit, return to welcome menu
				int doexit = 0;
				
				//user has three time to enter validate pin
				for (int i = 0; i < 3; i++){
					//keypad enter PIN
					pin = keypad.getInput();
					
					//validate pin
					if(bankDatabase.validatePIN(accountNumber, pin)){
						while(true){//----------------------------------------main menu
							//validate pin then go to main menu
							screen.displayMainMenu();
							
							//keypad enter choice, screen show different menu
							int choice = keypad.getInput();
										
							
							switch(choice){
								case 1: BalanceInquiry bi = new BalanceInquiry(accountNumber, screen, bankDatabase);//view account balance
										bi.execute();
										break;
								case 2: Withdrawal w = new Withdrawal(accountNumber, screen, bankDatabase);;//withdrawal cash
										w.execute();
										break;
								case 3: Deposit d =  new Deposit(accountNumber, screen, bankDatabase);//deposit funds
										d.execute();
										break;
								case 4: doexit = 1;
										break;//exit
								default:doexit = 1; 
										break;//any other keys to exit
							}
							
							if(doexit == 1){
								break;
							}
							
							//after transaction choose to main menu or exit
							screen.afterTransactionChoice();
							
							choice = keypad.getInput();
							//if choice is 1 or other, go back to main menu; if choice is 2, exit
							if(choice == 2){
								break;
							}
							
						}//-----------------------------------------------------end main menu
						
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
		}//-----------------------------------------------------------------------end welcome menu 
	}

}
