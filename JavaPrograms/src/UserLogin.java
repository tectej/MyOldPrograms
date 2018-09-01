
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * This program lets users login and shows Student's report to Teachers and  Math Quiz to Students.
 * Date - 12-08-2014
 * @author Tejas
 *
 */
public class UserLogin {

	public static void main(String[] args) {
		UserLogin ul = new UserLogin();
		System.out.print("Login to Math Quiz \nEnter UserId:\t ");
		Scanner sc = new Scanner(System.in);
		String userId = sc.next();
		System.out.print("\nEnter Name:\t ");
		String name = sc.next();
		System.out.println();
		ul.UserLogin(userId, name);
	}

/**
 * Method to Authenticate Users based on UserId. 
 * @param userId
 * @param name
 */
	public void UserLogin(String userId, String name) {

		if (userId.startsWith("S")) {
			Student1 s = new Student1();
			s.name = name;
			s.showMenu();

		} else if (userId.startsWith("T")) {
			Teacher t = new Teacher();
			t.name = name;
			t.showMenu();
		}
	}
}

abstract class User {
	String userId;
	String name;
	String password = "1234";
	// Url where file for results will be stored.

	public static final String ResultFilePath = "f:\\Students_Test_Record.txt";

	public abstract void showMenu();

}

class Student1 extends User {

	@Override
	public void showMenu() {
		System.out.println("Logged In as Student. Hello " + name);
		System.out.println();
		MathQuiz m = new MathQuiz();
		try {
			BufferedWriter brf = new BufferedWriter(new FileWriter(ResultFilePath));

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
			String date = df.format(Calendar.getInstance().getTime());

			brf.append(("Student Name: "+name + "  Test Date:" + date + m.showQuizMenu()));
			brf.flush();
			brf.close();
			System.out.println("Record Saved Successfully!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class Teacher extends User {

	@Override
	public void showMenu() {
		System.out.println("Logged In as Teacher. Hello " + name);
		System.out.println();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ResultFilePath));
			String nextLine = "";
			while((nextLine = br.readLine())!= null)
				System.out.println(nextLine);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}