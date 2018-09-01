//Write down program for printing rectangle of asterisks.
//*****************
//*<--spaces--> *
//*<--spaces--> *
//* <--spaces-->*
//*****************

public class AsterisksRectangle {

	public static void main(String[] args) {
	
		for (int i = 0; i < 5; i++) {
			System.out.print("*");
			for (int j = 0; j < 10; j++) {
				if (i == 0 || i == 4) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("*");
		}
	}
}