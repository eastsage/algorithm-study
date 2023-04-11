import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//FIN
public class Main {
	static int[][] map;
	static int[] papers = { 0, 5, 5, 5, 5, 5 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		search(0, 0, 0);//0,0 위치에서부터 시작. 현재까지 사용한 종이 수 0

		if (answer == Integer.MAX_VALUE) answer = -1;	
		System.out.println(answer);
	}

	//x,y 위치에 종이를 붙여 봄. 현재까지 사용한 종이 수는 cnt 
	public static void search(int x, int y, int cnt) {
	// 맨 끝점에 도달하였을 경우, ans와 cnt 비교하고 종료.	
		if (x == 9 && y == 10) {//x==9마지막 줄, y==9인 경우에도 붙일 수 있어서 y는 9보다 커야 함.비교할 거 다 해봄
			answer = Math.min(answer, cnt);
			return;
		}

		// 최솟값을 구해야하는데 ans보다 cnt가 커지는 순간 더 이상 탐색할 필요가 없어짐.
		if (answer <= cnt) {
			return;
		}

		// 아래 줄로 이동.
		if (y == 10) {//한 열의 끝이면 아래로 내려가기
			search(x + 1, 0, cnt);
			return;
		}
		
		if (map[x][y] == 1) {//1이 적힌 칸은 모두 색종이로 덮여져야 한다.
			for (int i = 5; i >= 1; i--) {//일단 큰종이 부터
				if (papers[i] > 0 && isPossible(x, y, i)) {//종이가 남아있고 x,y위치에 i크기 종이 붙이는 게 가능하다면
					attach(x, y, i, 9); // 색종이를 붙임. x,y위치에 i크기의 색종이를 붙임.1인 영역이 붙이는 자리이므로 0으로 바꿈 
					papers[i]--;						
					search(x, y + i, cnt + 1);//가로 방향으로 다음 위치에 가서 다시 붙여 봄
					
					attach(x, y, i, 1); // 색종이를 다시 뗌.
					papers[i]++;
				}
			}
		} else { // 오른쪽으로 이동.
			search(x, y + 1, cnt);
		}
	}

	//색종이를 붙이는 함수. x,y위치에서 시작해서 size크기의 종이를 붙임.
	public static void attach(int x, int y, int size, int state) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = state;
			}
		}
	}

	// 색종이를 붙일 수 있는지 확인.x,y위치에서 시작해서 size크기의 종이 붙이는 게 가능한지 체크
	public static boolean isPossible(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}

				//1인 칸이 있어야 함
				if (map[i][j] != 1) {//1이 적힌 칸은 모두 색종이로 덮여져야 한다.원래 빈칸이거나 이미 종이가 놓여 졌거나
					return false;
				}
			}
		}
		return true;//배열 밖으로 나가지 않고 모두 통과된다면 붙일 수 있어 
	}
}