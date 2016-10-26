package application;

/**
 * Write a description of class ScheduleMain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MainDraft
{

    /**
     * The main menu selections
     */
    public static void mainMenu()
    {
    	System.out.println("What would you like to do?");
        System.out.println("1. Create a schedule for this week");
        System.out.println("2. Edit existing employee data");
        System.out.println("3. Add a new employee");
        System.out.println("4. Remove an employee");
        System.out.println("5. Save changes to employees");
        System.out.println("Enter QUIT to Quit");
        System.out.println();
    }
    
    /**
     * The employee menu selections
     */
    public static void employeeDataMenu()
    {
        System.out.println("1. New weekly availability");
        System.out.println("2. Change or add job");
        System.out.println("3. Make keyholder/Change keyholder status");
        System.out.println("4. Return to main menu");
        System.out.println();
    }

    
    /**
     * The main method for the program
     */
    @SuppressWarnings({ "resource", "unused" })
	public static void main(String [] args)
    {
        boolean over = false;
        
        //Each job is determined by whether or not unique training is required.
        //For example dayCook and nightCook require different training, so they are different jobs.
        Job[] jobInit = new Job[10];
        
        Job dayCook = new Job("day cook");
        Job nightCook = new Job("night cook");
        Job dayPrep = new Job("day prep cook");
        Job nightPrep = new Job("night prep cook");
        Job openRegister = new Job("open register");
        Job closeRegister = new Job("close register");
        Job midRegister = new Job("midday register");
        Job dish = new Job("dishwasher");
        Job dayServer = new Job("day server");
        Job nightServer = new Job("night server");
        
        jobInit[0] = dayCook;
        jobInit[1] = nightCook;
        jobInit[2] = dayPrep;
        jobInit[3] = nightPrep;
        jobInit[4] = dish;
        jobInit[5] = openRegister;
        jobInit[6] = midRegister;
        jobInit[7] = closeRegister;
        jobInit[8] = dayServer;
        jobInit[9] = nightServer;
        
        ArrayList<Shift> allShifts = new ArrayList<Shift>();
        for(int i = 0; i < 6; i++)
        {
            allShifts.add(new Shift("Open Register", openRegister, i, 7, 30, 14, 0));
            allShifts.add(new Shift("Open Cook", dayCook, i, 7, 30, 15, 30));
            allShifts.add(new Shift("Day Prep Cook", dayPrep, i, 9, 30, 14, 30));
            allShifts.add(new Shift("Day Dish", dish, i, 11, 0, 15, 0));
            allShifts.add(new Shift("Server A", dayServer, i, 11, 0, 14, 30));
            allShifts.add(new Shift("Server B", dayServer, i, 12, 15, 15, 00));
            allShifts.add(new Shift("Second Register", midRegister, i, 12, 0, 16, 30));
            allShifts.add(new Shift("Night Cook", nightCook, i, 15, 30, 23, 0));
            allShifts.add(new Shift("Night Register", closeRegister, i, 16, 30, 23, 0));
            allShifts.add(new Shift("Night Prep Cook", nightPrep, i, 17, 00, 20, 30));
            allShifts.add(new Shift("Night Dish", dish, i, 18, 0, 23, 0));
            allShifts.add(new Shift("Server C", nightServer, i, 18, 0, 23, 0));
        }
        
        
        ArrayList<Employee> allEmployees = readWrite.readEmployeeData();
        Job[] jobList = readWrite.readJobData(jobInit, allEmployees); 
        
        while(!over)
        {
        mainMenu();
        Scanner in = new Scanner(System.in);
        String mainSelect = in.next();
        
        if (mainSelect.equals("1"))
        {
            //Create a schedule for this week
            boolean scheduleDone = false;
            while (!scheduleDone){
            System.out.println("Choose day:");
            for(int i = 0; i < 6; i++)
            {
                System.out.println(i + ". Set " + Quarter.getDay(i) + " Schedule");
            }
            //Outputs the week schedule and exits the schedule module
            System.out.println("7. Done");
            int scReply = in.nextInt();
            if (scReply == 7){
                scheduleDone = true;
                for(int l = 0; l < 6; l++)
                {
                System.out.println(Quarter.getDay(l));
                System.out.println();
                for (Shift sh2: allShifts)
                {
                    if (sh2.getDay() == l)
                    {
                        String empAssigned = "";
                        String startTime = String.format("%02d", sh2.getShiftStartHour());
                        startTime = startTime + ":" + String.format("%02d", sh2.getShiftStartMin());
                        String endTime = String.format("%02d", sh2.getShiftEndHour());
                        endTime = endTime + ":" + String.format("%02d", sh2.getShiftEndMin());
                
                        if (sh2.getAssigned() == null){empAssigned = "Unassigned";}
                        else{empAssigned = sh2.getAssigned().getCafeName();}
                        System.out.print(l + ". " + sh2.getName() + " ");
                        System.out.print(startTime+ " - " + endTime);
                        System.out.println(" : " + empAssigned);
                    }
                    
                }
                System.out.println();
                System.out.println();
                }
            }
            
            //Set the schedule for each individual day
            else{
            ArrayList<Shift> thisDayShifts = new ArrayList<Shift>();
            for(Shift sh: allShifts)
            {
                if (sh.getDay() == scReply)
                {
                    thisDayShifts.add(sh);
                }
            }
            boolean dayDone = false;
            System.out.println("Pick a shift to assign:");
            while (!dayDone)
            {
                for (int i = 0; i < thisDayShifts.size(); i++)
                {   
                    String empAssigned = "";
                    String startTime = String.format("%02d", thisDayShifts.get(i).getShiftStartHour());
                    startTime = startTime + ":" + String.format("%02d", thisDayShifts.get(i).getShiftStartMin());
                    String endTime = String.format("%02d", thisDayShifts.get(i).getShiftEndHour());
                    endTime = endTime + ":" + String.format("%02d", thisDayShifts.get(i).getShiftEndMin());
                
                    if (thisDayShifts.get(i).getAssigned() == null){empAssigned = "Unassigned";}
                    else{empAssigned = thisDayShifts.get(i).getAssigned().getCafeName();}
                    System.out.print(i + ". " + thisDayShifts.get(i).getName() + " ");
                    System.out.print(startTime+ " - " + endTime);
                    System.out.println(" : " + empAssigned);
              
                }
                //Opt out of finishing today's shifts
                System.out.println(thisDayShifts.size() + ". Done");
                System.out.println();
                int shInt = in.nextInt();
                if (shInt == thisDayShifts.size()){dayDone = true;}
                else
                {   
                ArrayList<Employee> whoCanWork = thisDayShifts.get(shInt).getEmployees();
                System.out.println();
                System.out.print(thisDayShifts.get(shInt).getName());
                System.out.println (" - " + thisDayShifts.get(shInt).getHourAmt() + " hours");
                System.out.println("Pick an employee to assign this shift to:");
                for (int w = 1; w < whoCanWork.size(); w++)
                {
                	//make sure employees get minimum hours and don't go over maximum hours
                	double minimum = 35.0;
                	double maximum = 40.0;
                    System.out.print(w + ". " + whoCanWork.get(w).getFullName());
                    if (whoCanWork.get(w) instanceof PartTimeEmp)
                    {
                    	PartTimeEmp curr = (PartTimeEmp)whoCanWork.get(w);
                    	minimum = curr.getHoursMin();
                    	maximum = curr.getHoursMax();		
                    }
                    double minLessAssigned = minimum - whoCanWork.get(w).getAssignedHours();
                    double maxLessAssigned = maximum - whoCanWork.get(w).getAssignedHours();
                    if (whoCanWork.get(w) instanceof FullTimeEmp && minLessAssigned > 0 )
                    {
                    	System.out.print(" !!Priority!!");
                    }
                    if (maxLessAssigned < 0)
                    {
                    	System.out.print(" !!Over Max Hours!!");
                    }
                    System.out.println(" " + minLessAssigned + " hours until minimum met");
                }
                System.out.println(whoCanWork.size() + ". No One");
                
                int wReply = in.nextInt();
                if (wReply == whoCanWork.size()){/*do nothing, no one selected*/}
                else{
                Employee picked = whoCanWork.get(wReply);
                //remove hours from assigned hours for any employee being replaced in the schedule
                if (thisDayShifts.get(shInt).getAssigned() != null)
                {thisDayShifts.get(shInt).getAssigned().assignHours(-(thisDayShifts.get(shInt).getHourAmt()));}
                thisDayShifts.get(shInt).assignEmployee(picked);
                picked.assignHours(thisDayShifts.get(shInt).getHourAmt());
                System.out.println(thisDayShifts.get(shInt).getAssigned().getFullName() + " has been assigned.");
                System.out.println();
                }
                }
            }
            }
            }
        }
        
        
        else if (mainSelect.equals("2"))
        {
            //Edit existing employee data
        
            boolean empOver = false;
            while(!empOver)
            {
                boolean goodSelection = false;
                boolean dataOver = false;
                int index = -1;
                
                //Select a specific employee to edit first
                while (!goodSelection)
                {
                System.out.println("Select an Employee from the list below to edit");
                for (int i = 0; i < allEmployees.size(); i++)
                {
                    System.out.println(i + ". " + allEmployees.get(i).getFullName());
                }
                System.out.println(allEmployees.size() + ". Do not edit any employees.");
                System.out.println();
                
                index = in.nextInt();
                
                //exit if no employees selected
                if (index == allEmployees.size()){goodSelection = true; empOver = true; dataOver = true;}
                else
                {
                    System.out.println("You selected " + allEmployees.get(index).getFullName() + ".  Is this correct? Y or N");
                    String reply = in.next().substring(0,1).toLowerCase();
                    while(!"yn".contains(reply))
                    {
                        System.out.println("Invalid Response. You selected " + allEmployees.get(index).getFullName() + ".  Is this correct? Y or N");
                        reply = in.next().toLowerCase();
                    }
                
                    if (reply.equals("y"))
                    { 
                        goodSelection = true;
                    }
                }
                }
                
                while(!dataOver)
                {
                    Employee current = allEmployees.get(index);
                    System.out.println();
                    employeeDataMenu();
                    String empSelect = in.next();
             
                    //Availability
                    if(empSelect.equals("1"))
                    {   
                    	if (current instanceof PartTimeEmp)
                    	{
                    		System.out.println("What are " + current.getFullName() + "'s minimum hours?");
                    		double min = in.nextDouble();
                    		System.out.println("What are " + current.getFullName() + "'s maximum hours?");
                    		double max = in.nextDouble();
                    		PartTimeEmp c = (PartTimeEmp)current;
                    		c.setHoursPerWeek(min, max);
                    	}
                    	
                        for (int i = 0; i< 7;i++)
                        {
                            System.out.println("When is " +  current.getFullName() + " available on " + Quarter.getDay(i) + "?");
                            System.out.println("1. Don't change availability for " + Quarter.getDay(i) + ".");
                            System.out.println("2. Available all day");
                            System.out.println("3. Unavailable all day");
                            System.out.println("4. Available part of the day");
                            System.out.println();
                            String aReply = in.next();
                            if (aReply.equals("1")){/*do nothing*/}
                            else if (aReply.equals("2")){current.setAvailable(i, true);}
                            else if (aReply.equals("3")){current.setAvailable(i, false);}
                            else if (aReply.equals("4"))
                            {
                            		current.setAvailable(i, false);
                            		System.out.println();
                            		System.out.println("Start Time");
                            		System.out.println("What time can " +  current.getFullName() + " start work on " + Quarter.getDay(i) + "?");
                            		System.out.println("Use 24-hour format time, such as \"8:30\" for 8:30 AM and \"20:30\" for 8:30 PM");
                            		System.out.println();
                            		String timeStart = in.next();
                            		timeStart = timeStart.replaceAll(":", " ");
                            		Scanner tS = new Scanner(timeStart);
                            		int startH = tS.nextInt();
                            		int startM = tS.nextInt();
                               
                            		System.out.println();
                            		System.out.println("End Time");
                            		System.out.println("What time must " +  current.getFullName() + " leave work " + Quarter.getDay(i) + "?");
                            		System.out.println("Use 24-hour format time, such as \"8:30\" for 8:30 AM and \"20:30\" for 8:30 PM");
                            		System.out.println();
                            		String timeEnd = in.next();
                                	timeEnd = timeEnd.replaceAll(":", " ");
                                	Scanner tE = new Scanner(timeEnd);
                                	int endH = tE.nextInt();
                                	int endM = tE.nextInt();
                                	current.setAvailable(i, startH, startM, endH, endM, true);
                            	
                            }

                        
                        }
                        System.out.println(current.getFullName());
                        Quarter[][] avail = current.getAvailability().getStartStopQuarters();
                        for (int j = 0; j< avail.length ;j++)
                        {
                            
                            
                            String day = avail[j][0].getDay();
                            int sHr = avail[j][0].getHour();
                            int sMi = avail[j][0].getStartMinute();
                            int eHr = avail[j][1].getHour();
                            int eMi = avail[j][1].getEndMinute();
                            
                            System.out.print(day.substring(0,3) + " - ");
                            System.out.printf("%02d", sHr);
                            System.out.printf(":%02d", sMi);
                            System.out.printf(" to %02d", eHr);
                            System.out.printf(":%02d", eMi);
                            
                            System.out.println();
                            
                            
                        }
                        System.out.println("Availability set for " + current.getFullName() + ". Edit other data for " + current.getFullName() + "? Y or N");
                        String sReply = in.next().substring(0,1).toLowerCase();
                        
                        while(!"yn".contains(sReply))
                        {
                             System.out.println("Invalid Response. Edit other data for " + current.getFullName() + "? Y or N");
                             System.out.println();
                             sReply = in.next().toLowerCase();
                        }
                            
                        if (sReply.equals("n"))
                        { 
                             dataOver = true;
                             System.out.println("Edit data for other employees? Y or N");
                             System.out.println();
                             String oReply = in.next().substring(0,1).toLowerCase();
                             while(!"yn".contains(oReply))
                             {
                                 System.out.println("Invalid Response. Edit data for other employees? Y or N");
                                 System.out.println();
                                 oReply = in.next().toLowerCase();
                             }
                             if (oReply.equals("n")){empOver = true;}
                        }
                    }
                        
                    
                    
                    else if(empSelect.equals("2"))
                    {
                        boolean jobOver = false;
                        while (!jobOver)
                        {
                           ArrayList<Job> jobsHeld = new ArrayList<Job>();
                           for (Job j : jobList)
                           { 
                               ArrayList<Employee> empList = j.getEmployeeList();
                               for (Employee e : empList)
                               {
                                   if (e == current)
                                   {
                                       jobsHeld.add(j);
                                   }
                               }
                           }
                           System.out.println("Jobs currently held by " + current.getFullName() + ":");
                           if (jobsHeld.size() > 0)
                           {
                               for (int i = 0; i < jobsHeld.size(); i++)
                               {
                                   System.out.println(i + ". " + jobsHeld.get(i).getJobName());
                               }
                               
                           }
                           else
                           {
                               System.out.println("None");
                               
                           }
                           System.out.println();
                           System.out.println("1. Remove job");
                           System.out.println("2. Add job");
                           System.out.println("3. Do not change job info");
                           System.out.println();
                           String jReply = in.next();
                           if (jReply.equals("1"))
                           {
                            if (jobsHeld.size() > 0)
                            {
                                System.out.println();
                                System.out.println("Select a job to remove:");
                                for (int i = 0; i < jobsHeld.size(); i++)
                                {
                                    System.out.println(i + ". " + jobsHeld.get(i).getJobName());
                                }
                                System.out.println();
                                
                                
                                jobList[in.nextInt()].removeEmployee(current);
                                
                                System.out.println();
                                System.out.println("Job removed.");
                                System.out.println();
                                
                            }
                            else
                            {
                                System.out.println("No jobs to remove");
                                System.out.println();
                                
                            }
                            
                        }
                           else if (jReply.equals("2"))
                           {
                               boolean jobAddOver = false;
                               while (!jobAddOver)
                               {
                                   System.out.println("Pick a job to add:");
                                  
                                  for (int j = 0; j< jobList.length; j++)
                                  {
                                      System.out.println(j + ". " + jobList[j].getJobName());
                                  }
                                  System.out.println();
                                  int jobSelect = in.nextInt();
                                  if (!jobList[jobSelect].getEmployeeList().contains(current))
                                  {jobList[jobSelect].addEmployee(current);}
                                  
                                  System.out.println();
                                  System.out.println("Add another job? Y or N");
                                  System.out.println();
                                  String jAReply= in.next().substring(0,1).toLowerCase();
                                  while(!"yn".contains(jAReply))
                                  {
                                      System.out.println();
                                      System.out.println("Invalid Response. Add another job? Y or N");
                                      System.out.println();
                                      jAReply = in.next().substring(0,1).toLowerCase();
                                  }
                                  if (jAReply.equals("n")){jobAddOver = true;}
                               }
                            }
                        
                             else if (jReply.equals("3")){jobOver = true;}
                       }
                    }
                        
                    else if(empSelect.equals("3"))
                    {
                        if (current.isKeyHolder())
                        {
                            System.out.println();
                            System.out.println( current.getFullName() + " is already a keyholder. Remove keys? Y or N");
                            System.out.println();
                            String kReply = in.next().substring(0,1).toLowerCase();
                            while(!"yn".contains(kReply))
                                  {
                                      System.out.println();
                                      System.out.println("Invalid Response. Remove keys? Y or N");
                                      System.out.println();
                                      kReply = in.next().substring(0,1).toLowerCase();
                                  }
                                  if (kReply.equals("y"))
                                  {
                                      current.giveKey(false);
                                  }
                        }
                        else
                        {
                            current.giveKey(true);
                            System.out.println();
                            System.out.println(current.getFullName() + " is now a keyholder.");
                            System.out.println();
                        }
                    }
                    
                    else if(empSelect.equals("4")){dataOver = true; empOver = true;}
                    
                    else{System.out.println(); System.out.println("Invalid Selection."); System.out.println();}
                }
            }
        }
            
            
        
        
        else if (mainSelect.equals("3"))
        {
            //Add a new employee
            boolean employeeAdded = false;
            System.out.println("Is the employee full time or part time?");
            System.out.println("1. Full time");
            System.out.println("2. Part time");
            int ftPt = in.nextInt();
            while (ftPt >2 ||ftPt <1)
            {
                System.out.println("Invalid selection");
                System.out.println("Is the employee full time or part time?");
                System.out.println("1. Full time");
                System.out.println("2. Part time");
                ftPt = in.nextInt();
            }
            
            System.out.println("What is the employee's first name?");
            String nameInput = in.next();
            System.out.println("What is the employee's last name?");
            nameInput = nameInput + " " + in.next();
            
            System.out.println("The employee's cafe name is " + Employee.getCafeName(nameInput) + ".  Is this correct? Y or N");
            System.out.println();
            String reply = in.next().substring(0,1).toLowerCase();
                
                while(!"yn".contains(reply))
                {
                    System.out.println();
                    System.out.println("Invalid response. The employee's cafe name is " + Employee.getCafeName(nameInput) + ".  Is this correct? Y or N");
                    System.out.println();
                    reply = in.next().toLowerCase();
                }
                
                if (reply.equals("y"))
                { 
                    if (ftPt==1)
                    {
                        allEmployees.add(new FullTimeEmp(nameInput));
                    }
                    if (ftPt==2)
                    {
                        allEmployees.add(new PartTimeEmp(nameInput));
                    }
                    employeeAdded = true;
                }
                else if (reply.equals("n"))
                {
                    System.out.println("What would you like the cafe name to be for this employee?");
                    String newCafeName = in.next();
                    if (ftPt==1)
                    {
                        allEmployees.add(new FullTimeEmp(nameInput));
                    }
                    if (ftPt==2)
                    {
                        allEmployees.add(new PartTimeEmp(nameInput));
                    }
                    allEmployees.get(allEmployees.size() - 1).setCafeName(newCafeName);
                    employeeAdded = true;
                }
                
                
                
            if (employeeAdded = true)
            {
                System.out.println();
                System.out.println("The employee " + allEmployees.get(allEmployees.size() - 1).getFullName() + " has been added with the cafe code name " + allEmployees.get(allEmployees.size() - 1).getCafeName());
                System.out.println();
            }
            
        }   
        else if(mainSelect.equals("4"))
        {
            //Remove an employee
            boolean goodSelection = false;
            while (goodSelection == false)
            {
                System.out.println("Select an Employee from the list below to remove:");
                for (int i = 0; i < allEmployees.size(); i++)
                {
                    System.out.println(i + ". " + allEmployees.get(i).getFullName());
                }
                System.out.println(allEmployees.size() + ". Do not remove any employees.");
                System.out.println();
                
                
                int index = in.nextInt();
                if (index == allEmployees.size()){goodSelection = true;}
                else
                {
                    System.out.println("You wish to remove " + allEmployees.get(index).getFullName() + " from the employee roster.");
                    System.out.println("Is this correct? Y or N");
                    System.out.println();
                    String reply = in.next().substring(0,1).toLowerCase();
                
                    while(!"yn".contains(reply))
                    {
                        System.out.println();
                        System.out.println("Invalid Response. You wish to remove " + allEmployees.get(index).getFullName() + " from the employee roster.  Is this correct? Y or N");
                        System.out.println();
                        reply = in.next().toLowerCase();
                    }
                
                    if (reply.equals("y"))
                    { 
                    	for (Job j: jobList)
                        {
                        	for (int i = 1; i < j.getEmployeeList().size(); i++)
                        	{                    		
                        		if (j.getEmployeeAt(i).equals(allEmployees.get(index)))
                        		{
                        			j.removeEmployee(i);
                        		}
                        	}
                        		
                        }
                        allEmployees.remove(index);
                        
                        goodSelection = true;
                    }
                }
                
            }
        }
        else if(mainSelect.equals("5"))
        {
            //Save changes to employees
            readWrite.writeJobData(jobList);
            readWrite.writeEmployeeData(allEmployees);
            System.out.println();
            System.out.println();
            System.out.println("Saved");
            System.out.println();
        
        }
        
        else if(mainSelect.equals("QUIT"))
        {
            
            //Enter QUIT to Quit
            over = true;
                
        }
        else
        {
            System.out.println();
             System.out.println("Invalid Selection");
             System.out.println();
        }
        }
    }
}
