import java.util.Scanner;
public class cpAutomation {

	public static void main(String[] args){
	
		char menuSelection;
		Scanner ms = new Scanner(System.in);
		
		do {

			System.out.println();
			System.out.println("Welcome to CPautomation");
			System.out.println();
			System.out.println("1. Input Sensor Data");
			System.out.println("2. Display Sensor Data");
			System.out.println("3. Exit");
			System.out.println();
			System.out.println("Please selected from the menu: ");
			menuSelection = ms.nextLine().charAt(0);
	
			if (menuSelection == '1'){
				System.out.println();
				System.out.println("Your selection was 1");
			}
    		else if (menuSelection == '2'){
    			System.out.println();
				System.out.println("Your selection was 2");
			}
			else{
		        System.out.println();	
				System.out.println("ERROR WRONG INPUT");
				System.out.println();
				System.out.println("Please try again");
			}
		
		}while(menuSelection != '3');
	}
}