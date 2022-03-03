import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean visited[][];
    static int dx[] = {-1,1,0,0,-1,1,-1,1};
    static int dy[] = {0,0,-1,1,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            int yLength = Integer.parseInt(st.nextToken());
            int xLength = Integer.parseInt(st.nextToken());
            if (xLength == 0 && yLength == 0){
                break;
            }
            map = new int[xLength][yLength];
            for (int i = 0; i < xLength; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < yLength; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[xLength][yLength];
            solution();
        }
    }
    static void solution(){
        int islandCount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] == 1){
                    islandCount += bfs(i,j);

                }
            }
        }
        System.out.println(islandCount);
    }
    static int bfs(int x, int y){
        int result = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()){
            Point tempPoint = q.poll();
            visited[tempPoint.x][tempPoint.y] = true;
            for (int i = 0; i < 8; i++) {
                int nextX = tempPoint.x + dx[i];
                int nextY = tempPoint.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextY < map[0].length && nextX < map.length){
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1){
                        q.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                        result++;
                    }
                }
            }
        }
        if (result > 1){
            return 1;
        }
        return result;
    }

}
