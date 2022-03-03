import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        solution();
    }
    static void solution(){
        int wolf = 0, sheep = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]){
                    int cnt = bfs(new Point(i,j));
                    if (cnt > 0){
                        sheep += cnt;
                    }else{
                        wolf += cnt;
                    }
                }
            }

        }
        wolf *= -1;
        System.out.println(sheep + " " + wolf);
    }
    static int bfs(Point startPoint){
        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);
        int wolf = 0, sheep = 0;
        visited[startPoint.x][startPoint.y] = true;

        while(!q.isEmpty()){
            Point tempPoint = q.poll();
            visited[tempPoint.x][tempPoint.y] = true;
            if (map[tempPoint.x][tempPoint.y] == 'v')
                wolf++;
            if (map[tempPoint.x][tempPoint.y] == 'o')
                sheep++;
            for (int i = 0; i < 4; i++) {
                int nextX = tempPoint.x + dx[i];
                int nextY = tempPoint.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && !visited[nextX][nextY]){
                    if (map[nextX][nextY] == 'v'){
                        q.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }else if (map[nextX][nextY] == 'o'){
                        q.add(new Point(nextX,nextY));
                        visited[nextX][nextY] = true;
                    }else if (map[nextX][nextY] == '.'){
                        q.add(new Point(nextX,nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        if (sheep > wolf){
            return sheep;
        }else{
            return -wolf;
        }
    }
}
