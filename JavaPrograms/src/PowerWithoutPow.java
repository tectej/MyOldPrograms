

public class PowerWithoutPow {
	public static void main(String[] args) {
	
		System.out.println(power(2, 3));
	}
	
	public static int power(int x, int y) {
		int product = 1;
		for (int i = 0; i < y; i++) {
			product*=x;
		}
		
		return product;
	}
}
