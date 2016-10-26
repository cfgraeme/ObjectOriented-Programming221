package application;

/**
 * A job has a name and a list of employees who have been trained for this job
 * 
 * @author Marge 
 * @version November 9, 2015
 */

import java.util.Arrays;
import java.util.ArrayList;
@SuppressWarnings("unused")
public class Job
{
    // instance variables - replace the example below with your own
    private String jobName;
    private Employee[] employees;

    /**
     * Constructor for objects of class Job
     */
    public Job(String name)
    {
       jobName = name;
       employees = new Employee[50];
       employees[0] = new Employee();
       employees[0].setName("No Employee");
       employees[0].setCafeName("none");
       employees[0].setOpenAvailable(true);
       //employees[0] should not be changed or removed
    }

    /**
     * This method returns the name of the job
     * @return the name of the job 
     */
    public String getJobName()
    {
        return jobName;
    }
    
    /**
     * This method adds an employee to the array of employees that can work this job
     * @param worker the employee being assigned this job
     */
    public void addEmployee(Employee worker)
    {
        int i = 1;
        while(employees[i] != null){i++;}
        employees[i] = worker;
    }
    
    /**
     * This method finds an employee based on an index
     * employee[0] cannot be gotten by this method
     * @param x the index of the employee to be found
     * @return the employee at the index
     */
    public Employee getEmployeeAt(int x)
    {
        try
        {
            if (x > 50 || x < 1)
            //employee[0] should not be gettable
            throw new IllegalArgumentException("Index is out of range");
            else if (employees[x] == null)
            throw new NullPointerException("No employee at specified index");
            return employees[x];
        }
        catch(NullPointerException g)
        {System.out.println(g.getMessage());
         return employees[0];}
        catch(IllegalArgumentException h)
        {System.out.println(h.getMessage());
         return employees[0];}
    }
    
    /**
     * This method finds and removes an employee
     * employee[0] cannot be removed by this method
     * @param worker the employee to be removed
     */
    public void removeEmployee(Employee worker)
    {
        int i = 1;
        while(!employees[i].equals(worker) && i < 51){i++;}
        if (i != 51)
        {
        employees[i] = null;
        }
    }
    
    /**
     * This method gets the index of an employee
     * employee[0] cannot be gotten by this method
     * @param worker the employee whose index is returned
     */
    public int getEmployeeIndex(Employee worker)
    {
        int i = 1;
        while(employees[i] != worker){i++;}
        return i;
    }
    
    /**
     * This method removes an employee at the specified index
     * employee[0] cannot be removed by this method
     * @param y the index of the employee to be removed
     */
    public void removeEmployee(int y)
    {
        try{
            if (y > 50 || y < 1)
            throw new IllegalArgumentException("Index is out of range");
            else if (employees[y] == null)
            throw new NullPointerException("No employee at specified index; may be already removed");
            employees[y] = null;}
        catch(NullPointerException g)
        {System.out.println(g.getMessage());}
        catch(IllegalArgumentException h)
        {System.out.println(h.getMessage());}
    }
    
    /**
     * This method converts the employee array to an arraylist for handling purposes
     * employee[0] is included in the arraylist
     * @return an arraylist of all employees who have been assigned to this job
     */
    
    public ArrayList<Employee> getEmployeeList()
    {
        
        ArrayList<Employee> employeesList = new ArrayList<Employee>();
        int i = 0;
        while(employees[i] != null && i < employees.length)
        {
            employeesList.add(employees[i]);
            i++;
        }
        return employeesList;
    }
}