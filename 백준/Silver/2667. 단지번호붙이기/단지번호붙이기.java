import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int N;
    static int[][] map;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N ][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        solution();
    }
    static void solution(){
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]){
                    int result = bfs(i,j);
                    resultList.add(result);
                }

            }
        }
        Collections.sort(resultList);
        System.out.println(resultList.size());
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
    }
    static int bfs(int x, int y){
        int result = 1;
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x,y));
        visited[x][y] = true;
        while (!q.isEmpty()){
            Point tempPoint = q.poll();
            visited[tempPoint.x][tempPoint.y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = tempPoint.x + dx[i];
                int nextY = tempPoint.y + dy[i];
                if (nextX < N && nextY < N && nextX >= 0 && nextY >= 0 && !visited[nextX][nextY] && map[nextX][nextY] == 1){
                    q.add(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
