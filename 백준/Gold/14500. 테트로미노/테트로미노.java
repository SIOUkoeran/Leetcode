import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans = -1;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                check(i, j, 1, map[i][j]);
                checkTshape(i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(ans);
    }

    private static void check(int i, int j, int depth, int sum) {
        if (depth == 4) {
            ans = Math.max(ans, sum);
            return ;
        }

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M){
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    check(nx, ny, depth + 1, sum + map[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    private static void checkTshape(int i, int j) {
        if (i + 2 < N && j + 1 < M) {
            int sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1];
            ans = Math.max(ans, sum);
        }

        if (i + 2 < N && j - 1 >= 0) {
            int sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j - 1];
            ans = Math.max(ans, sum);
        }

        if (i - 1 >= 0 && j + 2 < M) {
            int sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i - 1][j + 1];
            ans = Math.max(ans, sum);
        }

        if (i + 1 < N && j + 2 < M) {
            int sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
            ans = Math.max(ans, sum);
        }
    }
}
