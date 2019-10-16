import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * CatalanRecursive.java
 * 
 * This program will compute the Catalan numbers recursively.
 * 
 * @author Jaylon Kiper
 * @version 2.0
 * Programming Project 3
 * FALL19
 */
public class CatalanRecursive {
	
		//Recursively calculates the nth possibilities
		private static long catalanRec(int n) {
		
			//Base case for catalanRec
			if(n <= 1) {
				
				return 1;
				
			}//end if statement
		
			return n * catalanRec(n - 1);
			
		}//end catalanRec method
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException{
		
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
			
			//Calls the catalanRec method and gives results
			long cN = (catalanRec(2 * N)) / (catalanRec(N + 1) * catalanRec(N));
			
			R = cN;
			
			//Ending time
			long end = System.currentTimeMillis();
			
			//Prints results
			System.out.println("C(" + N + ") = " + R +"");
			System.out.println();
			
			//Prints time
			System.out.println("Time: " + (end - start) + "ms");
			System.out.println();
			
			//Creating a File object that represents the disk file. 
			PrintStream catR = new PrintStream(new File("CatRecursionResults.txt"));
						
			//Store current System.out before assigning a new value 
			PrintStream console = System.out;
			
			//Assign results to output stream
			System.setOut(catR);
			System.out.println(+ N + ", " + R + ", " +(end - start)+ " milliseconds");
			System.out.println();
				
			//Use stored value for output stream 
			System.setOut(console);
			System.out.print("Would you like to continue? Y/N: ");
			selection = scan.next().charAt(0);
				
		}while(selection == 'Y');
					
			
	}//end main

}//end class
