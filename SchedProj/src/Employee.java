package application;

/**
 * This class defines the employee by name, and gives the employee attributes regarding availability
 * 
 * @author marge 
 * @version November 13, 2015
 */

import java.util.ArrayList;
@SuppressWarnings("unused")
public class Employee
{
    private double hoursAssigned = 0; 
    private String fullName;
    private String cafeName = "none";
    private boolean keyHolder;
    private Week availability;
    

    /**
     * Constructor for objects of class Employee
     * @param name the cafe name of the employee
     */
    public Employee()
    {
        keyHolder = false;
        availability = new Week();
    }
    
    /**
     * This method sets the name of the new employee
     */
    public void setName(String name)
    {
        fullName = name;
        String cafeNameTry = "";
        for(int i = 0; i < fullName.split(" ").length; i++)
        {
           cafeNameTry = cafeNameTry + fullName.split(" ")[i].substring(0,2);
        }
        cafeNameTry = cafeNameTry.toLowerCase();
        if (cafeName.length() != 4)
        throw new IllegalArgumentException("Cafe name must be four letters in length");
        try{cafeName = cafeNameTry;}
        catch(IllegalArgumentException d)
        {System.out.println(d.getMessage());}
    }
    
    /**
     * This method returns the full name of the employee
     * @return the full name of the employee
     */
    public String getFullName()
    {
        return fullName;
    }
    
    /**
     * This method returns the cafe name
     * Cafe name refers to the first two letters of the first and last names 
     * @return the cafe name of the employee
     */
    public String getCafeName()
    {
        return cafeName;
    }
    
    /**
     * This method returns the cafe name, given a name as a string
     * Cafe name refers to the first two letters of the first and last names 
     * @return the cafe name of the employee
     */
    public static String getCafeName(String name)
    {
        String cafeNameTry = "";
        String statCafeName = "none";
        for(int i = 0; i < name.split(" ").length; i++)
        {
           cafeNameTry = cafeNameTry + name.split(" ")[i].substring(0,2);
        }
        cafeNameTry = cafeNameTry.toLowerCase();
        if (statCafeName.length() != 4)
        throw new IllegalArgumentException("Cafe name must be four letters in length");
        try{statCafeName = cafeNameTry;
            return statCafeName;}
        catch(IllegalArgumentException d)
        {System.out.println(d.getMessage());
         return "Bad input.  Make sure there are no spaces in the first or last name.";}
        }
    
     /**
     * This method sets the cafe name to something other than the default
     * Cafe name refers to the first two letters of the first and last names
     * @throws IllegalArgumentException if the cafename is not four letters in length
     * @return the cafe name of the employee
     */
    public void setCafeName(String newCafeName)
    {
        if (newCafeName.length() != 4)
        throw new IllegalArgumentException("Cafe name must be four letters in length");
        try{cafeName = newCafeName.toLowerCase();}
        catch(IllegalArgumentException d)
        {System.out.println(d.getMessage());}
        
    }
    
    /**
     * This method sets the employee as a keyholder or a non-keyholder
     * All employees are initially non-keyholders
     * @param keyhold true if the employee is a keyholder false if not
     */    
    public void giveKey(boolean keyhold)
    {
        keyHolder = keyhold;
    }
    
    /**
     * This method returns whether or not the employee is a keyholder <br>
     * All employees are initially non-keyholders
     * @return whether the employee is a keyholder or not
     */    
    public boolean isKeyHolder()
    {
        return keyHolder;
    }
    
    /**
     * This method gives the employees availability via a week object with quarters set on and off
     * @return a week object belonging to this employee, representing the employee's weekly availability
     */
    public Week getAvailability()
    {
        return availability;
    }
    
    /**
     * This method sets a time block on or off, corresponding to an employee's availability
     * Exceptions aren't needed for this method because they are contained in the week method referenced within
     * @param day the integer index of the day of the week (0-6)
     * @param sH the starting hour for this block of time (0-23)
     * @param sM the starting minute for this block of time, to be rounded to a quarter hour (0-59)
     * @param eH the ending hour for this block of time((0-23)
     * @param eM the ending minute for this block of time (0-59)
     * @param o whether the timeblock is in use(true) or not in use(false)
     */
    public void setAvailable(int day, int sH, int sM, int eH, int eM, boolean on)
    {
    	availability.setTimeBlock(day, sH, sM, eH, eM, on);	
    	
    }
    
    /**
     * This method sets the time block of an entire day
     * such that the entire day is on or the entire day is off
     * Exceptions aren't needed for this method because they are contained in the week method referenced within 
     * @param day the integer index of the day of the week(0-6)
     * @param o whether the timeblock is in use(true) or not in use(false)
     */
    public void setAvailable(int day, boolean on)
    {
        availability.setTimeBlock(day, on);
    }
    
    /**
     * This method sets the full week as on or off
     * Exceptions aren't needed for this method because they are contained in the week method referenced within 
     * @param o whether the week is in use(true) or not in use(false)
     */
    public void setOpenAvailable(boolean on)
    {
        availability.setTimeBlock(0, on);
        availability.setTimeBlock(1, on);
        availability.setTimeBlock(2, on);
        availability.setTimeBlock(3, on);
        availability.setTimeBlock(4, on);
        availability.setTimeBlock(5, on);
        availability.setTimeBlock(6, on);
    }
    
    /**
     * This method increments assigned hours
     * @param x the amount of hours to be added
     */
    public void assignHours(double x)
    {
    	hoursAssigned = hoursAssigned + x; 
    }
    
    /**
     * This method increments assigned hours
     * @return the amount of hours assigned
     */
    public double getAssignedHours()
    {
    	return hoursAssigned; 
    }
    
}

