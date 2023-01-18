import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b[] = new int[a];

		for (int i = 0; i < a; i++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
			b[i] = c+d;
		}

		for (int i = 0; i < a; i++) {
			System.out.println("Case #" + (i+1) + ": " + b[i]);
		}
	}
}