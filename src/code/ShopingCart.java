package code;

import java.util.Scanner;

public class ShopingCart {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String product;
		double price;
		int quantity;
		char currency ='₹';
		double total;
		String isDiscount;
		double discount;
		
		System.out.println("Enter the Product that you wanna buy! ");
		product = in.nextLine();
		System.out.println("\nEnter the price of that product! ");
		price = in.nextDouble();
		System.out.println("\nHow many of them! ");
		quantity = in.nextInt(); //Integer.parseInt(in.nextInt());
		in.nextLine(); //how nextInt will leave new line character and how the nextLine method will not work after that 
		System.out.println("\nIs there any discount (Yes/N0)?! ");
		isDiscount = in.nextLine();
		
//		if(isDiscount == "yes") {
			if(isDiscount.equalsIgnoreCase("yes")) {
			System.out.println("How much is the Discount (in %)! ");
			double discountPercent = in.nextDouble();
			
			total = quantity * price;
			discount = (discountPercent/100) * total; //calculate discount
			total = ((quantity * price) - discount) ; //update total
			System.out.println("SO YOU HAVE IN YOUR CART\n"
					+ "\nPRODUCT -> " + product 
					+ "\nPRICE --> " + price + currency 
					+ "\nSub_Total -->" + quantity * price + currency 
					+ "\n\nWith added discount of " + discountPercent 
					+ "% \n\nyou need to pay in_total " + total + currency);

		}else {
			total = quantity * price;
			System.out.println("SO YOU HAVE IN YOUR CART\n"
					+ "\nPRODUCT -> " + product 
					+ "\nPRICE --> " + price + currency 
					+ "\n\nYOU NEED TO PAY -->" + total + currency);
		}
		
		
		
		in.close();

	}

}
