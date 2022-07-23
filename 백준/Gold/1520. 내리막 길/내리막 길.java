import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M,N;
    static int[][] map;
    static long[][] dp;
    static int[] dx = {1,0,0, -1};
    static int[] dy = {0,1,-1, 0};
    static class Info implements Comparable<Info>{
        int x,y;
        long cnt;
        public Info(int x, int y, long cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            return (int) (this.cnt - o.cnt);
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new long[M][N];
        for (int i = 0; i < M; i ++){
            Arrays.fill(dp[i], -1);
        }
    }
    static  void solution() {
        Point p = new Point(0,0);
        dfs(p);
        System.out.println(dp[0][0]);
    }
    static long dfs(Point point){
        if (point.x == M - 1 && point.y == N - 1){
            return 1;
        }
        if (dp[point.x][point.y] != -1)
            return dp[point.x][point.y];
        dp[point.x][point.y] = 0;
        for (int i = 0; i < 4; i++){
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N){
                if (map[point.x][point.y] > map[nx][ny])
                    dp[point.x][point.y] += dfs(new Point(nx, ny));
            }
        }
        return dp[point.x][point.y];
    }
}
