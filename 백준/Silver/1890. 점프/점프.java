import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static long[][] dp;
    static int[] dx = {1,0};
    static int[] dy = {0, 1};
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], - 1);
        }
    }
    static  void solution() {
        dfs(new Point(0,0));
        System.out.println(dp[0][0]);
    }
    static long dfs(Point point){
        if (point.x == N - 1 && point.y == N - 1)
            return 1;

        if (map[point.x][point.y] == 0)
            return 0;
        if (dp[point.x][point.y] != -1)
            return dp[point.x][point.y];

        dp[point.x][point.y] = 0;
        for (int i = 0; i < 2; i++) {
            int nx = dx[i] * map[point.x][point.y] + point.x;
            int ny = dy[i] * map[point.x][point.y] + point.y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                dp[point.x][point.y] += dfs(new Point(nx, ny));
            }
        }
        return dp[point.x][point.y];
    }

}
