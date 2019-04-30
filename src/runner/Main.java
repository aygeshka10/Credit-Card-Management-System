package runner;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main  {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Integer choice = 0;
		Tranaction_runnable t = new Tranaction_runnable();
		Customer_runnable c = new Customer_runnable();
		
		while (choice != 8) {
			menu();
			try {
				choice = sc.nextInt();
				if (choice < 1 || choice > 8) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException i) {
				System.out.println("Incorrect input. Please try again!");
				sc.nextLine();
			}
			switch (choice) {
			case 1:
				t.getdisplayByZip();
				break;
			case 2:
				t.getTotalByType();
				break;
			case 3:
				t.getTotalByState();
				break;
			case 4:
				c.checkExistingAccount();
				break;
			case 5:
				c.updateCustomerAccount();
				
				break;
			case 6:
				c.generateMonthlyBill();
				break;
			case 7:
				c.getTransactionBetweenDates();
				break;
			case 8:
				System.out.println("\nByyyeee!!");
				break;
			}
			
		}
		sc.close();
	
		}
	public static void menu() {
		System.out.println("\nChoose an action:");
		System.out.println("1. Display the transactions made by customer living in a given zip");
		System.out.println("2. Display the number and total values of transactions for a given type");
		System.out.println("3. Display the number and total values of transactions in a given state");
		System.out.println("4. Check the existing account details");
		System.out.println("5. Modify the existing account details");
		System.out.println("6. Generate monthly bill");
		System.out.println("7. Display the transaction made between two dates");
		System.out.println("8. Quit");
	}
}
