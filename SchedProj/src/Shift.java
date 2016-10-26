package application;

/**
 * A shift is a work period within the week, which has a job, a timeblock, and must be assigned an employee
 * 
 * @author Marge
 * @version November 9, 2015
 */
import java.util.ArrayList;

public class Shift
{
    private String shiftName;
    private Job job;
    private int day;
    private int startHour;
    private int endHour;
    private int startMin;
    private int endMin;
    private int startQuarterOfShift;
    private int endQuarterOfShift;
    private Week shiftWeek;
    private ArrayList<Employee> available;
    private Employee assigned;
    /**
     * Constructor for objects of class Shift
     */
    public Shift(String name, Job j, int d, int sH, int sM, int eH, int eM)
    {
        shiftName = name;
        job = j;
        day = d;
        startHour = sH;
        endHour = eH;
        startMin = sM;
        endMin = eM;
        
        
        shiftWeek = new Week();
        shiftWeek.setTimeBlock(d, sH, sM, eH, eM, true);
        startQuarterOfShift = shiftWeek.getStartStopQuarters()[0][0].getQuarterOfWeekIndex();
        endQuarterOfShift = shiftWeek.getStartStopQuarters()[0][1].getQuarterOfWeekIndex();
    }

    /**
     * This method gets the name of the shift
     * @return the name of the shift as a string
     */
    public String getName()
    {
        return shiftName;
    }
    
    /**
     * This method gets the job assigned to this shift
     * @return the job object of this shift
     */
    public Job getJob()
    {
        return job;
    }
    
    /**
     * This method gets the day assigned to this shift
     * @return the int index of the day
     */
    public int getDay()
    {
        return day;
    }
    
    /**
     * This method gets the start hour of this shift
     * @return the start hour of the shift
     */
    public int getShiftStartHour()
    {
        return startHour;
    }
    
    /**
     * This method gets the start minute of this shift
     * @return the start minute of the shift
     */
    public int getShiftStartMin()
    {
        return startMin;
    }
    
    /**
     * This method gets the end hour of this shift
     * @return the end hour of the shift
     */
    public int getShiftEndHour()
    {
        return endHour;
    }
    
    /**
     * This method gets the end minute of this shift
     * @return the end minute of the shift
     */
    public int getShiftEndMin()
    {
        return endMin;
    }
    
    /**
     * This method returns the total number of hours in this shift
     * @return the total number of hours in this shift
     */
    public double getHourAmt()
    {
    	double quarters = endQuarterOfShift - startQuarterOfShift;
    	return quarters/4.0;
    }
    
    /**
     * This method gets an array of all the employees who are trained for the job this shift requires
     * and who are available for the shift's time block
     * @return an arraylist of all the employees who could work this shift
     */
    public ArrayList<Employee> getEmployees()
    {
        ArrayList<Employee> hasJob = job.getEmployeeList();
        available = new ArrayList<Employee>();
        for (Employee emp: hasJob)
        {
            Week empWeek = emp.getAvailability();
            Quarter[][] empAvail = empWeek.getStartStopQuarters();
            for (int i = 0; i<empAvail.length; i++)
            {
                int empStartQ = empAvail[i][0].getQuarterOfWeekIndex();
                int empEndQ = empAvail[i][1].getQuarterOfWeekIndex();
                if(empStartQ <= startQuarterOfShift && empEndQ >= endQuarterOfShift)
                {available.add(emp);}
            }
            
        }
        return available;
    }
    
    /**
     * This method assigns an employee to this shift using the getEmployees arraylist
     * @param x the index of the employee to be assigned out of the arraylist of employees created 
     * in the getEmployees method
     */
    
    public void assignEmployee(int x)
    {
        assigned = this.getEmployees().get(x);
    }
    
    /**
     * This method assigns an employee to this shift
     * @param y the Employee object to be assigned.
     */
    public void assignEmployee(Employee y)
    {
        assigned = y;
    }
    
    /**
     * This method gets the employee who has been assigned to this shift
     * @return the employee assigned to this shift
     */
    public Employee getAssigned()
    {
        return assigned;
    }
}
