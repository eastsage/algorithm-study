import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = 0;
		for (int i = 1; i < 10; i++) {
			b = i * a;
			System.out.println(a + " * " + i + " = " + b);
		}

	}
}