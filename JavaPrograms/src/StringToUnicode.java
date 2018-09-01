import java.text.Format;
import java.util.Scanner;
import java.util.regex.*;

public class StringToUnicode
{
public static void main(String[] args) {

/**
* Program to get java code to convert String To unicode Equivalent
* @author Tejas Patil
* Date- 12-07-2014
*/

Scanner sc = new Scanner(System.in);
System.out.println("Enter a String to convert into unicode Quivalent code: ");

String str = sc.nextLine();
StringBuffer sbf = new StringBuffer();

char[] stringToConvert = str.toCharArray();

for(char c:stringToConvert)
{
int character = c;
sbf.append(character+" ");
}

String toPaste = "System.out.printf(\"";

for(int i=0;i<stringToConvert.length;i++){
toPaste += "%c"; 
}
toPaste+="\",";
Pattern p = Pattern.compile("[0-9]+");
Matcher m = p.matcher(sbf);

StringBuffer finalRight = new StringBuffer();

while(m.find())
{
finalRight.append((m.group()+","));
}

finalRight.replace(finalRight.length()-1, finalRight.length(), "");

System.out.println("\n\ncopy-paste below line to your code:\n ");

System.out.println(toPaste+finalRight+");");

}
}