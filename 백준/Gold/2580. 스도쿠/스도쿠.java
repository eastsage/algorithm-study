import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[][] sudoku;
	static List<int[]> emptyPos = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sudoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (sudoku[i][j] == 0) {
					emptyPos.add(new int[] {i, j});
				}
			}
		}
		makeSudoku(0);
	}

	static void makeSudoku(int cur) {
		if (cur == emptyPos.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		int[] pos = emptyPos.get(cur);
		int x = pos[0];
		int y = pos[1];
		for (int i = 1; i <= 9; i++) {
			if (isValid(x, y, i)) {
				sudoku[x][y] = i;
				makeSudoku(cur + 1);
				sudoku[x][y] = 0;
			}
		}
	}

	static boolean isValid(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[x][i] == num) return false;
			if (sudoku[i][y] == num) return false;
		}

		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		for (int i = startX; i < startX + 3; i++) {
			for (int j = startY; j < startY + 3; j++) {
				if (sudoku[i][j] == num) return false;
			}
		}
		return true;
	}
}