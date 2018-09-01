
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student> {
/*
* Program to Take Student Grades and print highest and lowest student
* @author Tejas
* Date-22-01-2015
*/
private int avg;
private int[] grades = new int[5];
private String name;
private int sum;

@Override
public int compareTo(Student o) {
if(o instanceof Student){
Student student = (Student)o;
return this.sum-student.sum;
}
return 0;
}

@Override
public String toString() {
return "Student [avg=" + avg + ", grades=" + Arrays.toString(grades)
+ ", name=" + name + ", sum=" + sum + "]";
}

@Override
public boolean equals(Object obj) {
if(obj instanceof Student){
Student student = (Student)obj;
return this.getName().equalsIgnoreCase(student.getName());
}
return false;
}

@Override
public int hashCode() {
return this.getName().hashCode();
}

public int getAvg() {
return avg;
}

public int[] getGrades() {
return grades;
}

public String getName() {
return name;
}

public int getSum() {
return sum;
}

public void setAvg(int avg) {
this.avg = avg;
}

public void setGrades(int[] grades) {
this.grades = grades;
}

public void setName(String name) {
this.name = name;
}


public void setSum(int sum) {
this.sum = sum;
}

}

public class StudentMarks{
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
System.out.print("Enter Number of students : ");
int numOfStudents = sc.nextInt();
System.out.println();

Set<Student> studentSet = new TreeSet<Student>();

for(int i=0;i<numOfStudents;i++){
Student student = new Student();
System.out.print("Enter Name :");
student.setName(sc.next());
System.out.println();
System.out.println("Enter 5 grades :");

int[] grades = new int[5];
for(int j=0;j<5;j++){
System.out.print("Grade"+(j+1) +" :");
grades[j]=sc.nextInt(); 
System.out.println();
}

student.setGrades(grades);
student.setSum(getSum(grades));
student.setAvg(student.getSum()/5);
studentSet.add(student);
}

List<Student> studentList=new ArrayList<Student>(studentSet);
System.out.println("Lowest"+studentList.get(0).getName());
System.out.println("Highest "+studentList.get(studentList.size()-1).getName());
}

public static int getSum(int[] grades){

int sum=0;

for(int nextGrade:grades){
sum+=nextGrade;
}
return sum;
}
}