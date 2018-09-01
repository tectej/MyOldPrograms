import java.io.*;
import java.util.HashMap;
import java.util.regex.*;

public class UniqueWordsCount
{
public static void main(String[] args) {
HashMap<String,Integer> wordCount = new HashMap<String, Integer>();

File file = new File("f:\\tejas.txt");

try{
BufferedWriter bw = new BufferedWriter(new FileWriter(file));

if(file.exists())
{
bw.write(" Word1 Word2 Word3 Word4 Word5 Word6 Word1 Word2 Word5 Word9 Word1 Word10");
bw.flush();
bw.close();
}

BufferedReader br = new BufferedReader(new FileReader(file));// read a large file containing words

String str;
if((str = br.readLine())!= null)
{
Pattern p = Pattern.compile("[a-zA-Z0-9]+"); //pattern depends on what you consider as a word.
Matcher m = p.matcher(str);

while(m.find())
{
String nextWord = m.group();

if(wordCount.get(nextWord)==null)
{
wordCount.put(nextWord, 1);
}
else
{
int oldcount = wordCount.get(nextWord);
wordCount.put(nextWord, ++oldcount);
}

}
}
}
catch(Exception e)
{
e.printStackTrace();
}

System.out.println(wordCount);

}
}