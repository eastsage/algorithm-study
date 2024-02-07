import java.util.*;
import java.io.*;

class Pair{
    int y;
    int x;

    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int[][] sudoku = new int[9][9];
    static ArrayList<Pair> req = new ArrayList<>();

    static void printSudoku(){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(sudoku[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean isPossibleNum(int y, int x, int num){
        int y_start =  (y/3)*3;
        int x_start = (x/3)*3;

        for(int i=0;i<9;i++){
            // 가로 기준 탐색
            if(sudoku[y][i]==num) return false;

            // 세로 기준 탐색
            if(sudoku[i][x]==num) return false;

            // 사각형 기준 탐색
            if(sudoku[y_start + i/3][x_start + i%3]==num) return false;
        }
        return true;
    }

    static void backtracking(int cnt){
        if(cnt == req.size()){
            printSudoku();
            System.exit(0);
        }

        int y = req.get(cnt).y;
        int x = req.get(cnt).x;
        for(int j=1;j<=9;j++){
            if(isPossibleNum(y,x,j)){
                sudoku[y][x] = j;
                backtracking(cnt+1);
                sudoku[y][x] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<9;j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if(sudoku[i][j] == 0) req.add(new Pair(i,j));
            }
        }

        backtracking(0);
    }
}