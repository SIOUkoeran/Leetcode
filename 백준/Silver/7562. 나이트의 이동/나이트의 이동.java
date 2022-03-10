import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int testCase;
    static int x,y,l;
    static int destinationX, destinationY;
    static int[][] map, dist;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int dx[] = {-2,-2,-1,-1,1,1,2,2};
    static int dy[] = {-1,1,-2,2,-2,2,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            st= new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            destinationX = Integer.parseInt(st.nextToken());
            destinationY = Integer.parseInt(st.nextToken());
            visited = new boolean[l][l];
            map = new int[l][l];
            dist = new int[l][l];
            solution();

        }
        System.out.println(sb);
    }
    static void solution(){

        bfs(x,y);
        sb.append(dist[destinationX][destinationY]).append('\n');
    }
    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Point currentPoint = q.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < l && nextY < l){
                    if (!visited[nextX][nextY]){
                        q.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                        dist[nextX][nextY] = dist[currentPoint.x][currentPoint.y] + 1;
                    }
                }
            }

        }
    }
}
