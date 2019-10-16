import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * CatalanDynamic.java
 * 
 * This program will compute the Catalan numbers 
 * using dynamic programming where previous values are stored.
 * 
 * @author Jaylon Kiper
 * @version 4.0
 * Programming Project 3
 * FALL1
 */
public class CatalanDynamic {
	
	//Dynamically returns the nth possibilities
	 private static long catalanDyn(int n) {
		
		//Stores the results
		int cat[] = new int[n + 2];
		
		//Base cases for binomialDyn
		cat[0] = 1;
		cat[1] = 1;
		
		//Fills the entries
		for(int i = 2; i <= n; i++) {
			
			cat[i] = cat[i - 1] * (4 * i - 2) / (i + 1);
			
		}//end for loop
		
		//Returns the last entry
		return cat[n];
		
	}//end catalanDyn method

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//Character values to chose with method is to be run.
		char selection;
				
		do {
				
			int N;//number of possibilities
			long R = 0;//sets result to zero

			//Prints the number of possibilities
			System.out.print("Please enter the number of possibilties: ");
			N = scan.nextInt();
			System.out.println();
				
			//Starting time
			long start = System.currentTimeMillis();
			
			//Calls the catalanDyn method and gives results
			R = catalanDyn(N);
			
			//Ending time
			long end = System.currentTimeMillis();
				
			//Prints results
			System.out.println("C(" + N + ") = " + R +"");
			System.out.println();
				
			//Prints time
			System.out.println("Time: " + (end - start) + "ms");
			System.out.println();
				
			//Creating a File object that represents the disk file. 
			PrintStream catD = new PrintStream(new File("CatDyanmicResults.txt"));
						
			//Store current System.out before assigning a new value 
			PrintStream console = System.out;
			
			//Assign results to output stream
			System.setOut(catD);
			System.out.println(+ N + ", " + R + ", " +(end - start)+ " milliseconds");
			System.out.println();
					
			//Use stored value for output stream 
			System.setOut(console);
			System.out.print("Would you like to continue? Y/N: ");
			selection = scan.next().charAt(0);
					
		}while(selection == 'Y');
							
	}//end main

}//end class
