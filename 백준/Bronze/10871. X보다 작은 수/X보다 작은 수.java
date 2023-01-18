import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int i = 0;
		int c[] = new int[a];
		for ( i = 0; i < a; i++)
			c[i] = sc.nextInt();
		for ( i = 0; i < a; i++) {
			if (c[i] < b)
				System.out.print(c[i] + " ");
		}
	}
}