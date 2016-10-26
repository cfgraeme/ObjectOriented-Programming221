package application;

/**
 * A week is comprised of 672 quarter hours, 
 * and contains functions for setting blocks of quarters to on or off 
 * (for use with shift weeks and employee weeks)
 * 
 * @author Marge 
 * @version November 13, 2015
 */

import java.util.ArrayList;

public class Week
{
   
    private Quarter[] theWeek;

    /**
     * Constructor for objects of class Week
     */
    public Week()
    {
        theWeek = new Quarter[672];
        for (int i = 0; i < 672; i++)
        {
            theWeek[i] = new Quarter(i);
        }
    }

    
    /**
     * getQuarterOfWeekIndex gives the index of a quarter out of the 672 quarter week, given the day, hour, and quarter of hour
     * @param d the index of the day (0-6)
     * @param h the index of the hour (24 hour time, 0-23)
     * @param q the index of the quarter
     * @throws IllegalArgumentException if the paramaters are outside of the bounds specified
     * @return the index, out of 672, of the quarter of the week.
     */
    public static int getQuarterOfWeekIndex(int d, int h, int q)
    {
        
        
        try 
        {
            if (d>6 || h>23 || q>3 || d<0 || h<0 || q<0)
                throw new IllegalArgumentException("Illegal day or time index");
            return ((d*96) + h*4 + q);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
        
    }
    
    /**
     * This method returns a quarter via the index it was assigned to in theWeek.
     * @param  q  the index of the quarter
     * @return the quarter at index q in theWeek.
     */
    public Quarter getQuarter(int q)
    {
        
        try
        {
            if (q >671 || q<0)
            throw new IllegalArgumentException("Illegal quarter of week index");
            return theWeek[q];
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            return new Quarter(0);
        }
    }
    
    /**
     * This method returns the array of quarters that compose the week
     * @return an array of all 672 quarters
     */
    public Quarter[] getTheWeek()
    {
        return theWeek;
    }
    
    /**
     * This method gives the count of how many quarters in the week are set to on; 
     * useful for determining if a particular employee is working more than their max
     * or less than their minimum number of hours
     * @return the number of quarters set to "on", or true.
     */
    public int getQuarterCount()
    {
        int count = 0;
        for (Quarter q : theWeek)
        {
            if (q.isUsed()){count++;}
        }
        return count;
    }
    
    
    /**
     * This method sets a block of time on or off,
     * used for setting employee availability and shift times
     * 
     * @param day the integer index of the day of the week (0-6)
     * @param sH the starting hour for this block of time (0-23)
     * @param sM the starting minute for this block of time, to be rounded to a quarter hour (0-59)
     * @param eH the ending hour for this block of time((0-23)
     * @param eM the ending minute for this block of time (0-59)
     * @param o whether the timeblock is in use(true) or not in use(false)
     * @throws IllegalArgumentException if the parameters are outside of the bounds of time
     */
        public void setTimeBlock(int day, int sH, int sM, int eH, int eM, boolean o)
    {
        
        try
        {
            if (sH>eH || (sH==eH && sM > eM))
            throw new ArithmeticException("Start time later than end time");
            if (sH > 23 || sH < 0 || eH > 23 || eH < 0 || sM > 59 || sM < 0 || eM > 59 || eM < 0)
            throw new IllegalArgumentException("Illegal Day or Time Index");
            int startHour = sH;
            int endHour = eH;
            int startQrtr = 0;
            int endQrtr = 0;
            if (sM == 0){startQrtr = 0;}
            else if (sM > 0 && sM <= 15){startQrtr = 1;}
            else if (sM > 15 && sM <= 30){startQrtr = 2;}
            else if (sM > 30 && sM <= 45){startQrtr = 3;}
            else if (sM > 45 && sM < 60)
            {
                startQrtr = 0;
                startHour = sH + 1;
            }
        
            if (eM >= 0 && eM < 14)
            {
                endQrtr = 3;
                endHour = endHour - 1;
            }
            else if (eM >= 14 && eM < 29){endQrtr = 0;}
            else if (eM >= 29 && eM < 44){endQrtr = 1;}
            else if (eM >= 44 && eM < 59){endQrtr = 2;}
            else if(eM == 59){endQrtr = 3;}
       
            int startIndex = getQuarterOfWeekIndex(day, startHour, startQrtr);
            int endIndex = getQuarterOfWeekIndex(day, endHour, endQrtr);
        
        
            for (int i = startIndex; i <= endIndex; i++)
            {
                theWeek[i].setUse(o);
            }
        }
        catch(IllegalArgumentException e)
        {
                System.out.println(e.getMessage());
        }
        catch(ArithmeticException d)
        {
                System.out.println(d.getMessage());
        }
    }
     
    
    /**
     * This method sets the time block using the QuarterOfWeekIndex
     * 
     * 
     * @param start the integer index of the start Quarter
     * @param stop the integer index of the stop Quarter
     * @param o whether the timeblock is in use(true) or not in use(false)
     * @throws IllegalArgumentException if d is outside of the boundaries specified
     */
    public void setTimeBlock(int start, int stop, boolean on)
    {
        try
        {
            if(start > 671 || start < 0 || start > 671 || start < 0 || stop<start)
            throw new IllegalArgumentException("Illegal index or interval");
        
            for (int i = start; i <= stop; i++)
            {
                theWeek[i].setUse(on);
            }
        }
        catch(IllegalArgumentException e)
        {System.out.println(e.getMessage());}
       
    }
    
    
    /**
     * This method sets the time block of an entire day
     * such that the entire day is on or the entire day is off
     * 
     * @param day the integer index of the day of the week(0-6)
     * @param o whether the timeblock is in use(true) or not in use(false)
     * @throws IllegalArgumentException if day is outside of the boundaries specified
     */
    public void setTimeBlock(int day, boolean on)
    {
        try{
            if(day > 6 || day < 0)
            throw new IllegalArgumentException("Illegal day index");
            int startIndex = getQuarterOfWeekIndex(day, 00, 0);
            int endIndex = getQuarterOfWeekIndex(day, 23, 3);
        
        
            for (int i = startIndex; i <= endIndex; i++)
            {
                theWeek[i].setUse(on);
            }
        }
        catch(IllegalArgumentException e)
        {System.out.println(e.getMessage());}
       
    }
    
    
    /**
     * This method finds all the quarters from theWeek that begin or end a block of time set to on.
     * post condition: for every start there must be a stop, for every stop there must be a start
     * @ return  a matrix array of start and stop quarters
     */
    public Quarter[][] getStartStopQuarters()
    {
        
        ArrayList<Quarter> stops = new ArrayList<Quarter>();
        for (int i = 0; i < theWeek.length; i++)
        {
            Quarter q = theWeek[i];
            
            if(q.isUsed() && (q.getHour() == 23 && q.getQuarter() == 3))
            {
                stops.add(q);
            }
            else if (q.isUsed() && (!theWeek[i+1].isUsed()))
            {
                stops.add(q);
            }
        }
        
        ArrayList<Quarter> starts = new ArrayList<Quarter>();
        for (int i = 0; i < theWeek.length; i++)
        {
            Quarter q = theWeek[i];
            
            if (q.isUsed() && (q.getHour() == 0 && q.getQuarter() == 0))
            {
                starts.add(q);
            }
            else if (q.isUsed() && (!theWeek[i-1].isUsed()))
            {
                starts.add(q);
            }
        }
        assert stops.size() == starts.size();
        
        Quarter[][] startStops = new Quarter[stops.size()][2];
        
        for (int i = 0; i< starts.size(); i++)
        {
            startStops[i][0] = starts.get(i);
        }
        
        for (int j = 0; j< starts.size(); j++)
        {
            startStops[j][1] = stops.get(j);
        }
        
        return startStops;
    }
}
