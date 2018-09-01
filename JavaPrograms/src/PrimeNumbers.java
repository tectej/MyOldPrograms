//Below is the program to generate prime numbers between 5 million to 20 million (in 68 seconds)

import java.io.*;
import java.util.*;

public class PrimeNumbers implements Serializable {

/**
* Program to generate prime numbers between 5 million to 20 million (in 68 seconds)
* 
* implementation of Sieve_of_Eratosthenes algorithm
* 
* @author Tejas Patil 
* 
* Date - 24-08-2014
* 
*/
public static void main(String[] args) throws FileNotFoundException {

long start = 5000000;
long end = 20000000;

long startTime = System.nanoTime();
System.out.println(startTime);
Map<Long,Boolean> map = new LinkedHashMap<Long,Boolean>();

map.put(2l, true);

for(long m=3;m<end;m+=2){
map.put(m, true);
}

for(long i=3;i<Math.sqrt(end);i+=2){
if(map.get(i)==true)
{
for(long j=i*i;j<end;j+=i)
{
map.put(j,false);
}
}
}

Iterator<Long> keys = map.keySet().iterator();

PrintStream ps = new PrintStream(new File("f:\\primeNum.txt"));
System.setOut(ps);

while(keys.hasNext())
{
Long key = keys.next();

if((map.get(key)==false)||(key<start)){
keys.remove();
}
}

System.out.println("Total prime numbers: "+map.size());

System.out.println(map.keySet());

System.out.println("Time Required : " + (System.nanoTime()-startTime)/1000000000 + " seconds");
}
}