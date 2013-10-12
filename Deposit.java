
public class Deposit extends Transaction{
	//attributes
	private double amount;
	//references to associated objects
	private Keypad keypad;
	private DepositSlot depositSlot;
	
	//no-argument constructor
	public Deposit(int accountNumber, Screen screen, BankDatabase bankDatabase, double amount){
		super(accountNumber, screen, bankDatabase);
		this.amount = amount;
		
	}
	
	//operations
	public void execute(){
		//create deposit slot
		DepositSlot depositSlot = new DepositSlot();
		keypad = new Keypad();
		
		//screen display deposit menu
		super.getScreen()
	}
}
