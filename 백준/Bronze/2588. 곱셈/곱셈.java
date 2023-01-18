import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		int c, d, e;
		int f;
		c = b % 10;
		f = b / 10;
		d = f % 10;
		e = b / 100;
		System.out.println(a * c);
		System.out.println(a * d);
		System.out.println(a * e);
		System.out.println(a * b);
	}
}