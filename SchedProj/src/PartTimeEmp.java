package application;

/**
 * A Part Time Employee works less than 35 hours per week
 * 
 * @author Marge
 * @version November 11, 2015
 */
public class PartTimeEmp extends Employee
{
    private double hoursPerWeekMin;
    private double hoursPerWeekMax;

    /**
     * Constructor for objects of class FullTimeEmp
     */
    public PartTimeEmp(String name)
    {
        super.setName(name);
    }

    /**
     * This method tells the user the maximum number of hours per week this employee is set to work 
     * @return the maximum number of hours this employee should work each week
     */  
    public double getHoursMax()
    {
        return hoursPerWeekMax;
    }
    
    /**
     * This method tells the user the minimum number of hours per week this employee is set to work 
     * @return the minimum number of hours this employee should work each week
     */
    public double getHoursMin()
    {
        return hoursPerWeekMin;
    }
    
    /**
     * This method sets the minimum and maximum hours per week for each employee
     * @param min the minimum number of hours (absolute min is 0)
     * @param max the maximum number of hours (absolute max is 40)
     * @throws IllegalArgumentException if min is larger than max, or if either is out of bounds
     */    
    public void setHoursPerWeek(double min, double max)
    {
        if(min < 0 || max < 0 || min > 35 || max > 35)
        throw new IllegalArgumentException("Max or min out of bounds for 0-40 hour workweek");
        if (min >max)
        throw new IllegalArgumentException("Minimum cannot be greater than maximum");
        try
        {
        hoursPerWeekMin = min;
        hoursPerWeekMax = max;
        }
        catch(IllegalArgumentException e)
        {System.out.println(e.getMessage());}
    }
}
