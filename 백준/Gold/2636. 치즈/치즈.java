import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//FIN
public class Main {
	
	public static int N, M, cheeseCnt, remainCheese, time;
	public static int[][] map;
	public static boolean[][] visit;//한번 간 곳을 공기가 다시 가지 않음
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 세로
		M = sc.nextInt();// 가로
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1)
					cheeseCnt++;//치즈카운트 세놓기
			}
		} // 입력 끝		
		
		while (cheeseCnt > 0) {//치즈가 하나라도 남아 있으면			
			remainCheese = cheeseCnt;//현재 치즈갯수를 남은 치즈 갯수에 저장시키고
			time++;//한시간 흐르고
			meltingCheese();//치즈한번 녹이고 옴
		}
		
		System.out.println(time);
		System.out.println(remainCheese);
	}

	//공기와 맞닿은 치즈(1) 찾으러 고고
	//(0,0)부터 시작해서 1인 부분 찾는 메소드
	public static void meltingCheese() {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0));//0,0부터 시작. 가장 자리는 치즈가 없다->공기가 있음. 공기의 위치 들어있음
		
		visit = new boolean[N][M];//공기는 같은 곳을 두번 가지 않음  
		visit[0][0] = true;//시작점. 가장 자리는 치즈가 없다->공기가 있음
		
		while (!que.isEmpty()) {
			Point p = que.poll();//처음에 시작점
			
			for (int i = 0; i < 4; i++) {//공기 주변으로 4방 탐색. 1을 발견할 때까지
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny])
					continue;
				
				if (map[nx][ny] == 1) {//이동하려는 위치가 치즈이면
					map[nx][ny] = 0;//녹여주고
					cheeseCnt--;//치즈갯수 하나 줄이고					
					
				} else  {//0. 공기이면 거기서 부터 다시 탐색하도록 큐에 넣음
					que.offer(new Point(nx,ny));
				}
				
				visit[nx][ny] = true;//녹인 경우이든 큐에 넣은 경우이든 모두 방문처리
			}
		}
	}
}