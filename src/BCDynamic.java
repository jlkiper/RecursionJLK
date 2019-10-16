import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * BCDynamic.java
 * 
 * This program will compute the binomial coefficient using
 * dynamic programming where the previous values of possibilities
 * and unordered outcomes are stored.
 * 
 * @author Jaylon Kiper
 * @version 3.0
 * Programming Project 3
 * FALL19
 */
public class BCDynamic {
	
	//Reduces the value to the lowest integer
	static int minimumInt(int x, int y) {
		
		return (x < y) ? x: y;
		
	}//end minimum
	
	//Dyanmically returns the value of binomial coefficient C(N,k)
	private static long binomialDyn(int n, int k) {
		
		//Stores the values in indeces
		int C[][] = new int[n + 1][k + 1];
		
		for(int i = 0; i <= n; i++) {
			
			for(int j = 0; j <= minimumInt(i, k) ; j++) {
				
				//Base case for binomialDyn
				if (j == 0 || j == i) {
					C[i][j] = 1;
				}//end if statement
				else {
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
				}//end else statement
					
			}//end inner for loop
			
		}//end for loop
		
		return C[n][k];
		
	}//end binomialDyn method

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
						
			//Calls the binomialDyn method and gives results
			R = binomialDyn(N, k);
				
			//Ending time
			long end = System.currentTimeMillis();
				
			//Prints results sentence
			System.out.println("There are " + R + " ways to choose " + k + " subsets from " + N + " items.");
			System.out.println();
				
			//Prints time
			System.out.println("Time: " + (end - start) + "ms");
			System.out.println();
				
			//Creating a File object that represents the disk file. 
			PrintStream bcD = new PrintStream(new File("BCDyanmicResults.txt"));
						
			//Store current System.out before assigning a new value 
			PrintStream console = System.out; 
			
			//Assign results to output stream
			System.setOut(bcD);
			System.out.println(+ N + ", " + k + ", " + R + ", " +(end - start)+ " milliseconds");
			System.out.println();
				
			//Use stored value for output stream 
			System.setOut(console);
			System.out.print("Would you like to continue? Y/N: ");
			selection = scan.next().charAt(0);
				
		}while(selection == 'Y');
					
	}//end main

}//end class
