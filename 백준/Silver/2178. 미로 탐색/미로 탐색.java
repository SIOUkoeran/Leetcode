import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,C,ans;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int dx[] = {-1,1,0,0};
    static int dy[]= {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = 0;
        ans = Integer.MAX_VALUE;
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 1; j < M + 1; j++) {
               map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j - 1)));
            }
        }
        solution();
    }
    static void solution(){
        bfs(1,1);
        System.out.println(dist[N][M]);
    }
    static void bfs(int x , int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        dist[x][y] = 1;
        while (!q.isEmpty()){
            Point currentPoint = q.poll();
            if (currentPoint.x == N && currentPoint.y == M){
                ans = Math.min(ans, dist[N][M]);
            }
            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                if (nextX >= 1 && nextY >= 1 && nextX < N + 1 && nextY < M + 1){
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1){
                        q.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                        dist[nextX][nextY] = dist[currentPoint.x][currentPoint.y] + 1;
                    }
                }
            }
        }
    }
}
