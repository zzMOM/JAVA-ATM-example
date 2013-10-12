
/**
 * Class Keypad represents an ATM's keypad
 * @author weiwu
 *
 */

import java.util.Scanner;

public class Keypad {
	//no attributes have been specified yet
	
	//no-argument keypad constructor
	public Keypad(){
		
	}
	
	//operations
	public int getInput(){
		Scanner keypad = new Scanner(System.in);
		return keypad.nextInt();
	}
}
