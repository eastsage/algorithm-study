import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int n;
	static int[][] map;
	static int[][][][][] dp;

	// M : 0, O : 1, L : 2, A : 3, 그외 알파벳: 4

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		

		map = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1][5][5][5];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						for (int m = 0; m < 5; m++) {
							dp[i][j][k][l][m] = -1;
						}
					}
				}
			}
		}

		for (int i = 1; i <= n; ++i) {
			String input = br.readLine();
			for (int j = 1; j <= n; ++j) {
				char ch = input.charAt(j - 1);
				if (ch == 'M')
					map[i][j] = 0;
				else if (ch == 'O')
					map[i][j] = 1;
				else if (ch == 'L')
					map[i][j] = 2;
				else if (ch == 'A')
					map[i][j] = 3;
				else
					map[i][j] = 4;
			}
		}

		System.out.println(recur(1, 1, 4, 4, 4));
	}

	static int recur(int x, int y, int prev3, int prev2, int prev1) {
		if (x < 1 || x > n || y < 1 || y > n) return 0;

		int cur = map[x][y];

		if (dp[x][y][prev3][prev2][prev1] != -1){
			return dp[x][y][prev3][prev2][prev1];
		}

		int tmp = 0;

		if (prev3 == 0 && prev2 == 1 && prev1 == 2 && cur == 3) ++tmp;

		tmp += Math.max(recur(x, y + 1, prev2, prev1, cur), recur(x + 1, y, prev2, prev1, cur));

		dp[x][y][prev3][prev2][prev1] = tmp;
		return tmp;
	}
}