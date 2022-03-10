import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,B;
    static int[][] map;
    static int[][] blank;
    static boolean[][] visited;
    static int ans;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = Integer.MIN_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = 0;
        map = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2){
                    visited[i][j] = true;
                }
            }
        }
        solution();
    }
    static void solution(){
        for (int i = 1; i < N + 1 ; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (map[i][j] == 0){
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }
        dfs(1,0);
        System.out.println(ans);
    }
    static void dfs(int idx, int selected_cnt){
        if (selected_cnt == 3){
            bfs();
            return;
        }
        if (idx > B) return;
        map[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1);

        map[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);
    }

    static void bfs(){
        Queue<Point> q = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++){
                visited[i][j] = false;
                if (map[i][j] == 2){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()){
            Point currentPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                if (nextX >= 1 && nextY >= 1 && nextX < N + 1 && nextY < M + 1){
                    if (map[nextX][nextY] == 0 && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        q.add(new Point(nextX, nextY));
                    }
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (map[i][j] == 0 && !visited[i][j]){
                    cnt++;
                }
            }
        }
        ans = Math.max(cnt, ans);
    }
}
