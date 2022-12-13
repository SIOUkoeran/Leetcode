
import java.awt.Point;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static int N,M,answer;
    static int map[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        input();
        solution();
        checkMap();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    q.add(new Point(i, j));
            }
        }
    }

    private static void solution() {
        Queue<Point> q2 = new LinkedList<>();
        answer = -1;
        while(!q.isEmpty()) {
            int length = q.size();
            answer++;
            for (int cnt = 0; cnt < length; cnt++) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx >= 0 && nx < M && ny >= 0 && ny < N){
                        if (!visited[nx][ny] && map[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            map[nx][ny] = 1;
                            q.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
    }
    private static void checkMap() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }

}
