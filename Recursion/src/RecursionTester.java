/**
 * Assignment:
 * Write a java class with four methods that are recursive.  The methods should have the following signatures:
 * int sumforwardrecursive(int num) - 2 points
 * int sumforwarditerative(int num) - 2 points
 * int sumbackwardrecursive(int num) - 2 points
 * int sumbackwarditerative(int num) - 2 points
 * The methods with recursive in the name should use recursion.  The methods with iterative should not use recursion.
 * The methods with forward will sum from 1 to the number.  The methods with backward will sum from from -1 backward to the number.
 * Add a class that tests valid and invalid input on your methods - 2 points
 * 
 * This is the Tester class specified in the assignment
 * 
 * @author Marge 
 * @version November 20, 2015
 */

import java.util.Scanner;

public class RecursionTester {
	
	private static Scanner in;

	public RecursionTester(){}
	
	/**
     * The main method for the program
     */
    public static void main(String [] args)
    {
    	
		in = new Scanner(System.in);
    	
    	System.out.println("Enter a number to be tested, Q to quit: ");
    	while (in.hasNextInt())
    	{
    		int i = in.nextInt();
    		
    		System.out.print("Forwards Recursive sum: ");
    		System.out.println(RecursionMethod.sumforwardrecursive(i, 1));
    		System.out.print("Forwards Iteritave sum: ");
    		System.out.println(RecursionMethod.sumforwarditerative(i, 1));
    	
    		System.out.print("Backwards Recursive sum: ");
			System.out.println(RecursionMethod.sumbackwardrecursive(i));
			System.out.print("Backwards Iteritave sum: ");
			System.out.println(RecursionMethod.sumbackwarditerative(i));
    		
    	}
    		
    	
    }
	
	

}
