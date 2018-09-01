//Performing date Manipulation in Java using add and roll methods from //Calendar class.



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
* Program to perform date manipulation operation like adding/rolling days 
* to day , month or year fields.
* 
* Date-09/08/2014
* 
* @author Tejas
* 
*/
public class DateManipulator {

Calendar c = Calendar.getInstance();

public static void main(String[] args) throws Exception{

DateManipulator dm = new DateManipulator();
System.out.println("Today's Date : "+formatDate(dm.c.getTime()));

Date date = dm.getDateInput();

System.out.println("Date entered by User : "+formatDate(date));


Date newDate = dm.addDays(date, 1);
System.out.println("Date After adding 1 day to Date "+
formatDate(date) +"\t : "+formatDate(newDate));


newDate = dm.addMonths(date, 4);
System.out.println("Date After adding 4 Months to Date "+ 
formatDate(date) +"\t : "+formatDate(newDate));

newDate = dm.addYears(date, 2);
System.out.println("Date After adding 2 Years to Date "+ 
formatDate(date) +"\t : "+formatDate(newDate));

newDate = dm.rollDays(date, 2);
System.out.println("Date After rolling 2 Days of Date "+ 
formatDate(date) +"\t : "+formatDate(newDate));

newDate = dm.rollMonths(date, 4);
System.out.println("Date After rolling 4 Months of Date "+ 
formatDate(date) +"\t : "+formatDate(newDate));

newDate = dm.rollYears(date, 2);
System.out.println("Date After rolling 2 Years of Date "+ 
formatDate(date) +"\t : "+formatDate(newDate));

/* Calendar.roll() VS Calendar.add() methods
* c.roll(Calendar.MONTH,true); to roll up day by 1
* to just roll the fields without actually adding days to date
* like 30/11/2014 c.roll(Calendar.DAY_OF_MONTH,true) will 
* result in output 01/11/2014
* but c.add(Calendar.DAY_OF_MONTH,1) will result in output 
*1/12/2014 means days actually gets added to date.
*/

}

public static String formatDate(Date d) {
SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
return df.format(d);
}

//To get a date from user in dd/MM/yyyy format
public Date getDateInput() {
Date d = null;
try {
Scanner sc = new Scanner(System.in);
System.out.println("Enter a date eg. 08/09/2014: ");
String userDate = sc.next();
SimpleDateFormat df;
df = new SimpleDateFormat("dd/MM/yyyy");
d = (Date) df.parse(userDate);
} 
catch (Exception e) {
e.printStackTrace();
}
return d;
}


public Date addDays(Date date, int days) {
c.setTime(date);
c.add(Calendar.DAY_OF_MONTH, days);
return c.getTime();
}


public Date addMonths(Date date, int months) {
c.setTime(date);
c.add(Calendar.MONTH, months);
return c.getTime();
}


public Date addYears(Date date, int years) {
c.setTime(date);
c.add(Calendar.YEAR, years);
return c.getTime();
}


public Date rollDays(Date date, int days) {
c.setTime(date);
c.roll(Calendar.DAY_OF_MONTH, days);
return c.getTime();
}


public Date rollMonths(Date date, int months) {
c.setTime(date);
c.roll(Calendar.MONTH, months);
return c.getTime();
}


public Date rollYears(Date date, int years) {
c.setTime(date);
c.roll(Calendar.YEAR, years);
return c.getTime();
}
}