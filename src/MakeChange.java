import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		/* TODO 
		 * 		add validation for user inputs
		 * 		add zero case
		 *
		 */
		
		Scanner sc=new Scanner(System.in);
		double totalPrice=getTotal();
		double change=getChange(totalPrice);
	
		int hundo=0, fiddy=0, twenty=0, tens=0, fives=0, ones=0;
		int c25=0, c10=0, c5=0, c1=0;
		double remainingChange=change+.005;
		
		while(remainingChange>=100) {
			remainingChange-=100;
			hundo++;
		}
		while(remainingChange>=50) {
			remainingChange-=50;
			fiddy++;
		}
		while(remainingChange>=20) {
			remainingChange-=20;
			twenty++;
		}
		while(remainingChange>=10) {
			remainingChange-=10;
			tens++;
		}
		while(remainingChange>=5) {
			remainingChange-=5;
			fives++;
		}
		while(remainingChange>=1) {
			remainingChange-=1;
			ones++;
		}
		while(remainingChange>=.25) {
			remainingChange-=.25;
			c25++;
		}
		while(remainingChange>.10) {
			remainingChange-=.10;
			c10++;
		}
		while(remainingChange>.05) {
			remainingChange-=.05;
			c5++;
		}
		while(remainingChange>.01) {
			remainingChange-=.01;
			c1++;
		}
		System.out.printf("Your change is: %.2f%n", change);
		System.out.printf("It will be distributed in the following denominations%n");
		System.out.printf("%d : hundreds  %d : fifties  %d : twenties  %d : tens  %d : fives  %d : ones%n%d : quarters  %d : dimes %d : nickels  %d : pennies%n Have a nice day!", hundo, fiddy, twenty, tens, fives, ones, c25, c10, c5, c1 );
	
		

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
	public static double getChange(double totalPrice) {
		Scanner sc=new Scanner(System.in);
		System.out.printf("Your total is: %.2f%n",totalPrice);
		System.out.println("Please enter payment amount.");
		double moneyInput=sc.nextDouble(), remainder=0;
		while (moneyInput<totalPrice) {
			remainder=totalPrice-moneyInput;
			System.out.printf("Insufficient funds remaining balance is %.2f%n",remainder);
			System.out.println("Please enter additional funds.");
			moneyInput+=sc.nextDouble();
		}
		remainder=totalPrice-moneyInput;
		
		return -remainder;
		
		
		
	}

}
