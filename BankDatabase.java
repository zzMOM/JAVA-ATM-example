import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;
import java.util.Hashtable;

public class BankDatabase {	
	Hashtable<Integer, Account> accountDatabase = new Hashtable<Integer, Account>();
	
	//no-argument constructor
	public BankDatabase(){
		
	}
	
	public void createBankDatabase(){
		Random rd = new Random();
		int number, p;
		double ab, tb;
		DecimalFormat df = new DecimalFormat("#.##"); 
		for(int i = 0; i < 100; i++){
			number = 10000 + i;
			p = 20000 + i;
			ab = Double.valueOf(df.format(rd.nextInt(10000000) + rd.nextDouble()));//2 decimal
			tb = Double.valueOf(df.format(ab + rd.nextInt(100000)));
			accountDatabase.put(number, new Account(number, p, ab, tb));
			//database output
			/*System.out.println(accountDatabase.get(number).getUserAccountNumber() + " " + accountDatabase.get(number).getPIN()
					+ " " + accountDatabase.get(number).getAvailableBalance() + " " + accountDatabase.get(number).getTotalBalance());*/
		}	
	}
	
	//check user account number
	public boolean authenticateUser(int accountNumber){
		return accountDatabase.containsKey(accountNumber);
	}
	
	//check pin
	public boolean validatePIN(int accountNumber, int pin){
		int p;
		p = accountDatabase.get(accountNumber).getPIN();
		return (p == pin);
	}
	
	//get balance
	public double getAvailabeBalance(int accountNumber){
		return (accountDatabase.get(accountNumber).getAvailableBalance());
	}
	
}
