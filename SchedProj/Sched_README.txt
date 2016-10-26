I opted to focus on getting a solid working console rather than a GUI.  Someday!
To run it, I’ve been using eclipse.

The selection is based on user input; it is easier to start with the csv files I included than to create new ones, but the program can be run without them initially and still create csv files later

Some bugs:
-Employees can still be assigned to two shifts that are happening at the same time; it’s up to the user to make sure that no employees are scheduled to be in two places at one time.

-Scheduling availability has a very minimal input validation; if a user enters an invalid time, the availability scheduler just moves on, rather than waiting for a valid time input.

-One goal I had that I didn’t achieve was being able to schedule multiple blocks of availability in one day; I wasn’t able to solve this problem in time.