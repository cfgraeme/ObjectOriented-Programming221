/**
 * Assignment:
 * Write a java class with four methods that are recursive.  The methods should have the following signatures:
 * int sumforwardrecursive(int num, int i) - 2 points
 * int sumforwarditerative(int num, int i) - 2 points
 * int sumbackwardrecursive(int num) - 2 points
 * int sumbackwarditerative(int num) - 2 points
 * The methods with recursive in the name should use recursion.  The methods with iterative should not use recursion.
 * The methods with forward will sum from 1 to the number.  The methods with backward will sum from from -1 backward to the number.
 * Add a class that tests valid and invalid input on your methods - 2 points
 * 
 * This is the class with the four methods specified by the first part of the assignment
 * 
 * @author Marge 
 * @version November 20, 2015
 */



public class RecursionMethod {
	
	
	public RecursionMethod(){}
	

	/*
	 * This method uses recursion and sums backward from the number to 1
	 * @param num the n value in 1 + 2 + 3 + ... + n
	 * @return the sum of the values
	 */
	static int sumbackwardrecursive(int num)
	{
		if (num < 0)
			throw new IllegalArgumentException("This method is for positive integers only");
		try
		{
			if (num == 0)
			{
				return 0;
			}
			if (num == 1)
			{
				return 1;
			}
			else
			{
				return num + sumbackwardrecursive(num - 1);
			}
		}
		catch(IllegalArgumentException e)
        {
			System.out.println(e.getMessage());
			return 0;
        }
		
	}
	
	/*
	 * This method does NOT use recursion and sums backward from the number to 1
	 * @param num the n value in 1 + 2 + 3 + ... + n
	 * @return the sum of the values
	 */
	static int sumbackwarditerative(int num)
	{
	
		if (num < 0)
			throw new IllegalArgumentException("This method is for positive integers only");
		try
		{
			int sum = 0;
			int i = num;
			while (i > 0)
			{
				sum = sum + i;
				i--;
			}
			return sum;
		}
		catch(IllegalArgumentException e)
        {
			System.out.println(e.getMessage());
			return 0;
        }
	}
	
	/*
	 * This method uses recursion and sums forward from an integer (usually 1) to the number
	 * @param num the n value in x + (x+1) + (x+2) + ... + n
	 * @param i the start value, "x" in the above equation
	 * @return the sum of the values
	 */
	static int sumforwardrecursive(int num, int i)
	{
		if (num < 0)
			throw new IllegalArgumentException("This method is for positive integers only");
		try
		{
			if (num == 0)
			{
				return 0;
			}
			
			if (i == num)
			{
				return num;
			}
			else
			{
				return  i + sumforwardrecursive(num, i + 1);
			}
		}
		catch(IllegalArgumentException e)
        {
			System.out.println(e.getMessage());
			return 0;
        }	
	}
	
	/*
	 * This method does NOT use recursion and sums forward from an integer (usually 1) to the number
	 * @param num the n value in x + (x+1) + (x+2) + ... + n
	 * @param i the start value, "x" in the above equation
	 * @return the sum of the values
	 */
	static int sumforwarditerative(int num, int i)
	{
		if (num < 0)
			throw new IllegalArgumentException("This method is for positive integers only");
		try
		{
			int sum = 0;
			int f = i;
			while (f <= num)
			{
				sum = sum + f;
				f++;
			}
			return sum;
		}
		catch(IllegalArgumentException e)
        {
			System.out.println(e.getMessage());
			return 0;
        }
	}
	
}
