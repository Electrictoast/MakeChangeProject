import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		/* TODO 
		 * 		if pay get user input for money provided
		 * 		check and make sure input is valid
		 * 		check and make sure money provided is sufficient
		 * 			if yes subtract price from provided. if no
		 * 			request more money.
		 * 		use if greater than inside loop to check denominations 
		 * 			that fit into result and subtract them.
		 * 			add quantities to variable tracking change output
		 * 		print amount of change and denominations provided in
		 *
		 */
		Scanner sc=new Scanner(System.in);
		double totalPrice=getTotal();
		System.out.printf("Your total is: %.2f%n",totalPrice);
		System.out.println("Please enter payment amount.");
		double moneyInput=sc.nextDouble();
		while (moneyInput<totalPrice) {
			double remainder=totalPrice-moneyInput;
			System.out.printf("insufficient funds remaining balance is %.2f%n",remainder);
			moneyInput+=sc.nextDouble();
		}
			
	
		

	}
	public static double getTotal() {
		Scanner sc=new Scanner(System.in);
		double itemPrice=0,totalPrice=0;
		String again="";
		int i= 0;
		
		System.out.println("Please enter the price of the item you would like to purchase.");
		do {
			if(i!= 0) {
				System.out.println("Please enter the price of the next item.");
			}
			itemPrice=sc.nextDouble();
			totalPrice+=itemPrice;
			System.out.println("Would you like to add another item? (Y/N)");
			again=sc.next();
			i++;
			
		}while(again.equals("y")|| again.equals("Y"));
		return totalPrice;
	}

}
