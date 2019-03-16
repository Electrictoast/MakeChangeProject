import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		double totalPrice=getTotal();
		double change=getChange(totalPrice);
		if (change!=0) {
			int hundo, fiddy, twenty, tens, fives, ones;
			int c25, c10, c5, c1;
			double remainingChange=change+.005;
			hundo=getBills(remainingChange, 100.00);
				remainingChange-= (hundo*100);
			fiddy=getBills(remainingChange, 50.00);
				remainingChange-= (fiddy*50);
			twenty=getBills(remainingChange, 20.00);
				remainingChange-= (twenty*20);
			tens=getBills(remainingChange, 10.00);
				remainingChange-= (tens*10);
			fives=getBills(remainingChange, 5.00);
				remainingChange-= (fives*5);
			ones=getBills(remainingChange, 1.00);
				remainingChange-= (ones*1);
			c25=getBills(remainingChange, .25);
				remainingChange-= (c25*.25);
			c10=getBills(remainingChange, .10);
				remainingChange-= (c10*.10);
			c5=getBills(remainingChange, .05);
				remainingChange-= (c5*.05);
			c1=getBills(remainingChange, .01);
				remainingChange-= (c1*.01);
			
			System.out.printf("Your change is: %.2f%n", change);
			System.out.printf("It will be distributed in the following denominations%n");
			System.out.println(printChange(hundo, fiddy, twenty, tens, fives, ones, c25, c10, c5, c1 ));
			System.out.println("Have a nice day!");
		}else {
			System.out.println("You've provided exact change\n\tThank You\n\t\tHave a nice day!");
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
			if (itemPrice>0) {
			totalPrice+=itemPrice;
			System.out.println("Would you like to add another item? (Y/N)");
			again=sc.next();
			i++;
			}else {
				System.out.println("ERROR\nYou have entered an invalid amount\nConfirm the price and try again.");
				again="y";
			}
			
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
		
		if(remainder>0) {
			return -remainder;
		}else {
			return 0;
		}
		
		
	}
	public static int getBills(double remainingChange, double denomination) {
		int count=0;
		while(remainingChange>denomination) {
			remainingChange-=denomination;
			count++;
		}
		return count;
		
	}
	public static String printChange(int hundo,int fiddy,int twenty,int tens,int fives,int ones,int c25, int c10,int c5,int c1 ) {
		String changePrint="";
		if (hundo>=1) {
			if (hundo==1) {
				changePrint+= hundo+" : Hundred ";
			}else if (hundo>1) {
				changePrint+= hundo+" : Hundreds ";
			}
		}
		if (fiddy>=1) {
			if (fiddy==1) {
				changePrint+= fiddy+" : Fifty ";
			}else if (twenty>1) {
				changePrint+= fiddy+" : Fifties ";
			}
		}
		if (twenty>=1) {
			if (twenty==1) {
				changePrint+= twenty+" : Twenty ";
			}else if (twenty>1) {
				changePrint+= twenty+" : Twenties ";
			}
		}
		if (tens>=1) {
			if (tens==1) {
				changePrint+= tens+" : Ten ";
			}else if (tens>1) {
				changePrint+= tens+" : Tens ";
			}
		}
		if (fives>=1) {
			if (fives==1) {
				changePrint+= fives+" : Five ";
			}else if (fives>1) {
				changePrint+= fives+" : Fives ";
			}
		}
		if (ones>=1) {
			if (ones==1) {
				changePrint+= ones+" : one ";
			}else if (ones>1) {
				changePrint+= ones+" : ones ";
			}
		}
		if (c25>=1) {
			if (c25==1) {
				changePrint+= c25+" : Quarter ";
			}else if (c25>1) {
				changePrint+= c25+" : Quarters ";
			}
		}
		if (c10>=1) {
			if (c10==1) {
				changePrint+= c10+" : Dime ";
			}else if (c10>1) {
				changePrint+= c10+" : Dimes ";
			}
		}
		if (c5>=1) {
			if (c5==1) {
				changePrint+= c5+" : Nickel ";
			}else if (c5>1) {
				changePrint+= c5+" : Nickels ";
			}
		}
		if (c1>=1) {
			if (c1==1) {
				changePrint+= c1+" : Penny ";
			}else if (c1>1) {
				changePrint+= c1+" : Pennies ";
			}
		}
		
		return changePrint;
	}

}
