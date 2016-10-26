package application;

/**
 * A Full Time Employee works at least 35 hours per week
 * Full Time Employees meeting their minimum hours gets precedence over scheduling part time employees
 * 
 * @author Marge
 * @version November 11, 2015
 */
public class FullTimeEmp extends Employee
{
    private double hoursPerWeekMin;
    private double hoursPerWeekMax;
    private boolean minimumMet;

    /**
     * Constructor for objects of class FullTimeEmp
     */
    public FullTimeEmp(String name)
    {
        hoursPerWeekMin = 35;
        hoursPerWeekMax = 40;
        minimumMet = false;
        super.setName(name);
    }

    /**
     * This method returns the maximum hours (should always be 40)
     * @return the maximum number of hours to be worked per week   
     */
    public double getHoursMax()
    {
        return hoursPerWeekMax;
    }
    
    /**
     * This method returns the minimum hours (should always be 35)
     * @return the minimum number of hours to be worked per week
     */
    public double getHoursMin()
    {
        return hoursPerWeekMin;
    }
    
    /**
     * This method returns the boolean minimumMet
     * @return the value of boolean variable minimumMet
     */
    public boolean isMet()
    {
        return minimumMet;
    }
    
    /**
     * This method returns the boolean minimumMet
     * @return the value of boolean variable minimumMet
     */
    public void setMet(boolean o)
    {
        minimumMet = o;
    }
}
