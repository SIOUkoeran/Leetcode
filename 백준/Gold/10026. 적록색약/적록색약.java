
import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static int N, answer = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static Character[][] map;

    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new Character[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
    }

    private static void solution(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]){
                    if (map[i][j] == 'R') {
                        detectColor(new Point(i, j), new Character[]{'R'});
                    } else if (map[i][j] == 'G'){
                        detectColor(new Point(i, j), new Character[]{'G'});
                    } else if (map[i][j] == 'B') {
                        detectColor(new Point(i, j ), new Character[]{'B'});
                    }
                }
            }
        }
        sb.append(answer).append(" ");
        answer = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'R' || map[i][j] == 'G') {
                        detectColor(new Point(i, j), new Character[]{'R', 'G'});
                    } else if (map[i][j] == 'B') {
                        detectColor(new Point(i, j), new Character[]{'B'});
                    }
                }
            }
        }
        sb.append(answer);
        System.out.println(sb);
    }
    private static void detectColor(Point point, Character[] colors) {
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        visited[point.x][point.y] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (visited[nx][ny]) continue;
                    if (isSameColor(colors, map[nx][ny])) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        ++answer;
    }

    private static boolean isSameColor(Character[] colors, Character c) {
        return Arrays.stream(colors)
            .anyMatch(color -> color == c);

    }
}
