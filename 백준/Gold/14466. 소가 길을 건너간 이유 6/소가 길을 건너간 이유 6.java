import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K,R;
    static int[][] map;
    static Queue<Point> q;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static Point[] cows;
    static boolean[][] visited, meet;
    static LinkedList<Point>[][] graphs;
    public static void main(String[] args) throws NumberFormatException, IOException {
        input();
        solution();
    }
    public static void solution(){
        int ans = 0;

        for (int i = 0; i < K; i++){
            Point cur = cows[i];
            bfs(cur);
            for (int j = i + 1; j < K; j++) {
                Point next = cows[j];
                if (!meet[next.x][next.y])
                    ++ans;

            }
        }
        System.out.println(ans);
    }
    private static int bfs(Point point){
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N + 1][N + 1];
        visited[point.x][point.y] = true;
        meet = new boolean[N + 1][N + 1];
        int ans = 0;
        q.add(point);
        visited[point.x][point.y] = true;
        while (!q.isEmpty()){
            Point cur = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (nx >= 1 && nx < N + 1 && ny >= 1 && ny < N + 1) {
                    if (!visited[nx][ny] && !graphs[cur.x][cur.y].contains(new Point(nx, ny))){
                        q.add(new Point(nx, ny));

                        visited[nx][ny] = true;
                        if (map[nx][ny] == -1){
                            meet[nx][ny] = true;
                        }
                    }
                }
            }
        }
        //System.out.println(ans);
        return ans;
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        graphs = new LinkedList[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++){
            for (int j = 1; j < N + 1; j++) {
                graphs[i][j] = new LinkedList<Point>();
            }
        }

        for (int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            graphs[r1][c1].add(new Point(r2, c2));
            graphs[r2][c2].add(new Point(r1, c1));
        }
        cows = new Point[K];
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = -1;
            cows[i] = new Point(r, c);
        }
    }
}

