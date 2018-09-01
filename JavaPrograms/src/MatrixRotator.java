import java.util.Scanner;

//Develop a java program to rotate each element of matrix by 1 in clockwise direction.

public abstract class MatrixRotator {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.println("\nEnter dimensions of matrix");

System.out.print("Enter Number of Rows: ");
int row = sc.nextInt();

System.out.print("Enter Number of Columns: ");
int column = sc.nextInt();

int[][] inputMatrix = new int[row][column];
System.out.println("\nEnter elements of matrix");

//take input Matrix
for(int i=0;i<inputMatrix.length;i++){
for(int j=0;j<inputMatrix[i].length;j++){
System.out.print("Enter Element:["+i+" "+j+"] :");
inputMatrix[i][j] = sc.nextInt();
System.out.println();
}
}

sc.close();

int[][] outputMatrix = new int[row][column];

System.out.println("Input Matrix:");
for(int i=0;i<inputMatrix.length;i++){
for(int j=0;j<inputMatrix[i].length;j++){
System.out.print(inputMatrix[i][j]+"\t");
}
System.out.println();
}

rotateMatrix(outputMatrix, inputMatrix);

System.out.println("Output Matrix:");

for(int i=0;i<inputMatrix.length;i++){
for(int j=0;j<inputMatrix[i].length;j++){
System.out.print(outputMatrix[i][j]+"\t");
}
System.out.println();
}
}

public static void rotateMatrix(int[][] outputMatrix,int[][] inputMatrix){

int rowStart = 0;
int columnStart = 0;

int maxRight = inputMatrix[rowStart].length-1;
int maxLeft = columnStart;
int maxDown = inputMatrix.length-1;
int maxUp = rowStart;

while(maxRight>maxLeft){

int tempRow = rowStart;
int tempColumn = columnStart;

//move Right
for(tempColumn=columnStart;tempColumn<maxRight;tempColumn++){
int[] temp = moveRight(rowStart,tempColumn);
outputMatrix[temp[0]][temp[1]] = inputMatrix[rowStart][tempColumn];
}

//move Down
for(tempRow=maxUp;tempRow<maxDown;tempRow++){
int[] temp = moveDown(tempRow,maxRight);
outputMatrix[temp[0]][temp[1]] = inputMatrix[tempRow][maxRight];
}

//move Left
for(tempColumn=maxRight;tempColumn>maxLeft;tempColumn--){
int[] temp = moveLeft(maxDown,tempColumn);
outputMatrix[temp[0]][temp[1]] = inputMatrix[maxDown][tempColumn];
}

//move Up
for(tempRow=maxDown;tempRow>maxUp;tempRow--){
int[] temp = moveUp(tempRow,maxLeft);
outputMatrix[temp[0]][temp[1]] = inputMatrix[tempRow][maxLeft];
}

rowStart++ ;
columnStart++ ;

maxRight--;
maxLeft = columnStart;
maxDown--;
maxUp = rowStart;
}

//System.out.println(maxLeft+" "+maxRight+" "+rowStart+columnStart);

if(maxLeft==maxRight){
outputMatrix[maxLeft][maxRight]=inputMatrix[maxLeft][maxRight];
}
}

public static int[] moveRight(int row,int column){
return new int[]{row,column+1};
}

public static int[] moveDown(int row,int column){
return new int[]{row+1,column};
}

public static int[] moveLeft(int row,int column){
return new int[]{row,column-1};
} 

public static int[] moveUp(int row,int column){
return new int[]{row-1,column};
}

}