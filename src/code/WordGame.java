package code;

import java.util.Scanner;

public class WordGame {

	public static void main(String[] args) throws Exception {
		
			String adjective1;
			String noun;
			String adjective2;
			String adjective3;
			
			Scanner in = new Scanner(System.in);
			
			System.out.print("Enter an adjective (Description of a place! like nice, super...)");
			adjective1 = in.nextLine();
			System.out.print("Enter a noun (place name!)");
			noun = in.nextLine();
			System.out.print("Enter a adjective what you felt!");
			adjective2 = in.nextLine();
			System.out.print("One more adjective about that place!");
			adjective3 = in.nextLine();
			

			System.out.println("\n-------HERE IS YOUR MASTERPIECE----------\n");				
			System.out.print("Today I went to a " + adjective1 + " place ");
			System.out.println("and that place is " + noun + ".");
			System.out.println("I was "+ adjective2 + " seeing that place.");
			System.out.println("and it's a " + adjective3 + " place to visit in freetime");
			
			in.close();
		}

}
