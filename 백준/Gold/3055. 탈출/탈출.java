import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] map;
    static int[][] water;
    static boolean[][] visited;
    static int[][] dist;
    static Queue<Integer> q = new LinkedList<>();
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int startX;
    static int startY;
    static int arrivalX;
    static int arrivalY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];
        water = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
                water[i][j] = -1;
                dist[i][j] = -1;
                if (temp.charAt(j) == '*'){
                    q.add(i);
                    q.add(j);
                    visited[i][j] = true;
                    water[i][j] = 0;
                }
                else if (temp.charAt(j) == 'S'){
                    startX = i;
                    startY = j;
                    dist[startX][startY] = 0;
                }else if (temp.charAt(j) == 'D'){
                    arrivalX = i;
                    arrivalY = j;
                }
            }
        }
        dist[arrivalX][arrivalY] = -1;
        solution();
    }
    static void solution(){
        bfsWater();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }
        bfs();

        if (dist[arrivalX][arrivalY] == -1){
            System.out.println("KAKTUS");
        }else{
            System.out.println(dist[arrivalX][arrivalY]);
        }

    }
    static void bfsWater(){
        while(!q.isEmpty()){
            int x = q.poll(); int y = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                    if (!visited[nextX][nextY] && map[nextX][nextY] == '.'){
                        q.add(nextX); q.add(nextY);
                        visited[nextX][nextY] = true;
                        water[nextX][nextY] = water[x][y] + 1;
                    }
                }
            }
        }
    }
    static void bfs(){
        q.add(startX); q.add(startY);
        visited[startX][startY] = true;
        dist[startX][startY] = 0;
        while (!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (map[nextX][nextY] != '.' && map[nextX][nextY] != 'D') continue;
                if (visited[nextX][nextY]) continue;
                if (water[nextX][nextY] != -1 && water[nextX][nextY] <= dist[x][y] + 1) continue;
                q.add(nextX); q.add(nextY);
                visited[nextX][nextY] = true;
                dist[nextX][nextY] = dist[x][y] + 1;
            }
        }
    }
}
