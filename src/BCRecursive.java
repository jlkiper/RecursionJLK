import java.util.Scanner;
import java.io.*;

/**
 * BCRecursive.java
 * 
 * This program will compute the binomial coefficient recursively
 * with a number based on possibilities and unordered outcomes, then
 * printing the results afterwards.
 * 
 * @author Jaylon Kiper
 * @version 3.0
 * Programming Project 3
 * FALL19
 */
public class BCRecursive {
	
	//Recursively calculates the possibilities and unordered outcomes.
	private static long binomialRec(int n, int k) {
		
		if (k==0) {
			return 1;
		}//end if statement
		else if (k > n - k) {
			return binomialRec(n, n - k);
		}//end else if statement
		else {
			return binomialRec(n - 1, k - 1) * n / k;
		}//end else statement
		
	}//end binomialRec method
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException{
		
		//Character values to chose with method is to be run.
		char selection;
		
		do {
			
			int N;//number of possibilities
			int k;//unordered outcomes
			long R = 0;//sets result to zero
			
			//Prints the number of possibilities
			System.out.print("Please enter the number of possibilties: ");
			N = scan.nextInt();
			System.out.println();
			
			//Prints the number of unordered outcomes
			System.out.print("Please enter the number of unordered outcomes: ");
			k = scan.nextInt();
			System.out.println();
			
			//Starting time
			long start = System.currentTimeMillis();
					
			//Calls the binomialRec method and gives results
			R = binomialRec(N, k);
			
			//Ending time
			long end = System.currentTimeMillis();
			
			//Prints results sentence
			System.out.println("There are " + R + " ways to choose " + k + " subsets from " + N + " items.");
			System.out.println();
			
			//Prints time
			System.out.println("Time: " + (end - start) + "ms");
			System.out.println();
			
			//Creating a File object that represents the disk file. 
			PrintStream bcR = new PrintStream(new File("BCRecursionResults.txt"));
			
			//Store current System.out before assigning a new value 
	        PrintStream console = System.out; 
				
			//Assign results to output stream
			System.setOut(bcR);
			System.out.println(+ N + ", " + k + ", " + R + ", " +(end - start)+ " milliseconds");
			System.out.println();
			
			//Use stored value for output stream 
			System.setOut(console);
			System.out.print("Would you like to continue? Y/N: ");
			selection = scan.next().charAt(0);
			
		}while(selection == 'Y');
			
	}//end main

}//end class
