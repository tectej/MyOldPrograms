public class Puzzle
{

private final String str;

Puzzle()
{
str="str".toUpperCase();
}

public void A()
{
System.out.println(new Puzzle().str);
}

public static void main(String[] args)
{
new Puzzle().A();
}

}