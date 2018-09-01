import java.util.ArrayList;
import java.util.Scanner;

/*
 * Program to display Math Quiz and Result.
 * 
 * Date-12-08-2014
 * @author-Tejas
 *  
 */

/**
 * The Math Quiz

Develop an application that creates a mathematical quiz to the primary school level. The quiz should contain 5 questions from the selected arithmetic operation (prompt user to select a topic):
Addition
+
Subtraction
-
Multiplication
*
Division
/

The questions should randomly display number of operand between -10 up to 50 only. Example of question shown below:
Assumed that the student choose “Addition” topic:
Question 1:
2 + 13 = ?
Question 2:
16 + 20 = ?
Question 3 :
-2 + 17 = ?
When the user answers the question correctly, display a congratulatory message. If the user responds to a question incorrectly, display an appropriate message as well as the correct answer. At the end of the quiz, display the number of correct and incorrect answers, and the percentage of correct answers
 * @author tectej
 *
 */


public class MathQuiz {

	String TestResult = ""; 
	
	public String showQuizMenu() {

		while(true)
		{
			System.out.println("*********Math Quiz Menu********");
			System.out.println("\n1.Addition press + \n2.Subtraction press - \n3.Multiplication press * \n4.Division press /");
			System.out.print("\nEnter A choice:\t");
			Scanner sc = new Scanner(System.in);
			String operation = sc.next();
			
			if(operation.equals("1"))
			{
				operation="+";
			}
			else if(operation.equals("2"))
			{
				operation="-";
			}
			else if(operation.equals("3"))
			{
				operation="*";
			}
			else if(operation.equals("4"))
			{
				operation="/";
			}
			
			
			TestResult = TestResult.concat(showQuestions(operation));
			
			System.out.print("Continue ?? [Y/N] : \t");
			String choice = sc.next();
			if(choice.equalsIgnoreCase("Y"))
			{
				continue;
			}
			else if(choice.equalsIgnoreCase("N"))
			{
				System.out.println();
				System.out.println("See you soon...");
				break;
			}
			break;
		}
		return TestResult;
	}

	/**
	 * Method to show questions and Result to Student
	 */

	public String showQuestions(String operation)
	{
		int correctAnswers=0;
		int incorrectAnswers=0;
         
		
		for(int i=1;i<6;i++)
		{
			Scanner sc = new Scanner(System.in);
			int answer;
			System.out.println("\nQuestion "+i+":");
			int operand1 = getOperant();
			int operand2 = getOperant();


			System.out.println(""+operand1 +" "+operation+" "+ operand2 +"= ?");			
			System.out.print("Enter Answer:\t");
			answer = sc.nextInt();

			int correctAnswer = getCorrectAnswer(operand1,operand2,operation);
			if(answer==correctAnswer)
			{
				System.out.println("\nCongratulation!! It's the correct answer!!");
				correctAnswers++;
			}
			else
			{
				System.out.println("\nSorry , The correct answer is: "+correctAnswer);
				incorrectAnswers++;
			}

			if(i==5)
			{
				System.out.println("\n\n Test Results: \n Number Of Correct Answers: "+correctAnswers+"\n Number Of InCorrect Answers: "+incorrectAnswers);
				System.out.println(" Percentage of Correct Answers:  "+ correctAnswers*100/5+" %\n\n");
		        
				TestResult = TestResult.concat("\n\n Test Results ("+operation+"): \n Number Of Correct Answers: "+correctAnswers+"\n Number Of InCorrect Answers: "+incorrectAnswers+"\n");
				TestResult = TestResult.concat(" Percentage of Correct Answers:  "+ correctAnswers*100/5+" %\n\n");
			   return TestResult;
			}
		}
		return TestResult;
	}

	/**
	 * Method to get correct answer
	 */

	public int getCorrectAnswer(int op1 , int op2 , String operation)
	{
		int answer=0;
		if(operation.equals("+"))
		{
			answer = op1 + op2;
		}
		else if(operation.equals("-"))
		{
			answer = op1 - op2;
		}
		else if(operation.equals("*"))
		{
			answer = op1 * op2;
		}
		else if(operation.equals("/"))
		{
			try{
				answer = op1 / op2;
			}
			catch(Exception e)
			{
				System.out.println("Can not Divide By 0");
			}
		}
		return answer;
	}

/**
 * Method to generate random numbers for operand
 */
	public int getOperant(){

		ArrayList<Integer> arr = new ArrayList<Integer>();

		for(int i=-10;i<=50;i++)
		{
			arr.add(i);
		}

		int num;
		while(arr.contains((num=(int) (Math.random()*100*arr.get((int)(Math.random()*10))/50)-5))){
			return num;	 
		}
		return (int)(Math.random()*50);
	}

}
