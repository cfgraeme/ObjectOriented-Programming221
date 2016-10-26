package application;

/**
 * Quarters are quarter hours, which compose the week and are assigned hours and days within the week
 * 
 * @author Marge
 * @version November 6, 2015
 */
public class Quarter
{
    public final static int[] MIN = {00, 15, 30, 45};
    public final static int[] ENDMIN = {14, 29, 44, 59};
    public final static String[] DAY = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private int quarterOfWeekIndex;
    private int quarterIndex;
    private int dayIndex;
    private int hourIndex;
    private int startMinute;
    private int endMinute;
    private boolean used;
    

    /**
     * Constructor for objects of class Quarter
     * A quarter is a 15 minute period, the smallest unit of "blockable" time for scheduling purposes.
     * Each quarter is indexed out of the full weeklong period, and has additional indexes for what 
     * day of the week this quarter is in, what hour of the day, and what quarter of the hour it is.
     */
    public Quarter(int q)
    {
        quarterOfWeekIndex = q;
        quarterIndex = quarterOfWeekIndex%4;
        dayIndex = q/96;
        hourIndex = (q%96)/4;
        startMinute = MIN[quarterIndex];
        endMinute = ENDMIN[quarterIndex];
        used = false;
    }
    
    /**
     * This method gives the index for the day of the week, starting at 0 for Monday and going to 6 for Sunday.
     * @ return the index of the day for this quarter
     */
    public int getDayIndex()
    {
        return dayIndex;
    }
    
    /**
     * This method gives the day name that corresponds to the day index, from Monday to Sunday.
     * @return the name of the day for this quarter, as a String.
     */
    public String getDay()
    {
        return DAY[dayIndex];
    }
    
    /**
     * This method gives the day name that corresponds to the int value passed, from Monday to Sunday.
     * @param an int identifying a day
     * @return the name of the day for the given int.
     */
    public static String getDay(int i)
    {
        try {return DAY[i];}
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            return "BAD INDEX";
        }
    }
    
    /**
     * This method gives the 24 hour index for this quarter, from 00 to 23.
     * @return the hour index for this quarter.
     */
    public int getHour()
    {
        return hourIndex;
    }
    
    /**
     * This method gives the 4 quarter index for this quarter, from 0 to 3.
     * @return the hour index for this quarter.
     */
    public int getQuarter()
    {
        return quarterIndex;
    }
    
    /**
     * This method gives the starting minute for this quarter, as 00, 15, 30, or 45.
     * @return the start minute for this quarter.
     */
    public int getStartMinute()
    {
        return startMinute;
    }
    
    /**
     * This method gives the ending minute for this quarter, as 14, 29, 44, or 59.
     * @return the end minute for this quarter.
     */
    public int getEndMinute()
    {
        return endMinute;
    }
    
    /**
     * This method returns the quarter 
     * @return the index, out of 672, of the quarter of the week.
     */
    public int getQuarterOfWeekIndex()
    {
        return quarterOfWeekIndex;
    }
    
    /**
     * This method sets this quarter hour as in use or not in use <br>
     * this can be used to set a quarter as in use by a shift, <br>
     * or to set an employee as available.
     * @param o true to set the block in use, false to set the block to not in use
     */
    public void setUse(boolean o)
    {
        used = o;
    }
    
    /**
     * This method returns whether or not the quarter is in use; true if it is in use
     * @return whether or not this quarter is in use. true if in use, false if not.
     */
    public boolean isUsed()
    {
        return used;
    }
}
