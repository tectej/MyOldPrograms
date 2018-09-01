import java.io.*;
import java.util.*;
public class NumberToDigital
{
public static void main(String[] args)
{
/**
* Class to Print Number to Digital Form.
* Date- 27-04-2014
* @author Tejas Patil
*
*/

Scanner sc = new Scanner(System.in);

System.out.println("Please Enter any Number : ");

long num = Long.parseLong(sc.next());

NumberToDigital t = new NumberToDigital();
System.out.println("The Number In digital Form is : ");

String str = Long.valueOf(num).toString();

//top
for(int i=0;i<str.length();i++)
{
if(str.charAt(i)=='2'|str.charAt(i)=='3'|str.charAt(i)=='5'|str.charAt(i)=='6'|str.charAt(i)=='7'|str.charAt(i)=='8'|str.charAt(i)=='9'|str.charAt(i)=='0')
{
t.drawLine();
}

System.out.print("\t\t");
}

System.out.println();

//Right or left right
for(int j =0;j<5;j++){
for(int i=0;i<str.length();i++)
{
if(str.charAt(i)=='1'|str.charAt(i)=='2'|str.charAt(i)=='3'|str.charAt(i)=='7')
{
t.right();
}
else if(str.charAt(i)=='4'|str.charAt(i)=='8'|str.charAt(i)=='9'|str.charAt(i)=='0')
{
t.leftRight();
}
else if(str.charAt(i)=='5'|str.charAt(i)=='6')
{
t.left();
}
System.out.print("\t\t");
}

System.out.println();
}

//Center

for(int i=0;i<str.length();i++)
{
if(str.charAt(i)=='2'|str.charAt(i)=='3'|str.charAt(i)=='5'|str.charAt(i)=='6'|str.charAt(i)=='4'|str.charAt(i)=='8'|str.charAt(i)=='9')
{
t.drawLine();

}
System.out.print("\t\t");
}
System.out.println();

//down right or left right
for(int j =0;j<5;j++){
for(int i=0;i<str.length();i++)
{
if(str.charAt(i)=='1'|str.charAt(i)=='3'|str.charAt(i)=='4'|str.charAt(i)=='5'|str.charAt(i)=='7'|str.charAt(i)=='9')
{
t.right();
}
else if(str.charAt(i)=='6'|str.charAt(i)=='8'|str.charAt(i)=='0')
{
t.leftRight();
}
else if(str.charAt(i)=='2')
{
t.left();
}
System.out.print("\t\t");
}

System.out.println();
}

//bottom

for(int i=0;i<str.length();i++)
{
if(str.charAt(i)=='2'|str.charAt(i)=='3'|str.charAt(i)=='5'|str.charAt(i)=='6'|str.charAt(i)=='8'|str.charAt(i)=='9'|str.charAt(i)=='0')
{
t.drawLine();
}
System.out.print("\t\t");
}
}

void drawLine()
{
System.out.print(" -----");
}

void right()
{
System.out.printf("%7s","|");
}

void left()
{
System.out.print("|");
}

void leftRight()
{
System.out.printf("| |"); 
// If program is not showing proper output , make sure there are 5 spaces in between two ' | ' .
}
}