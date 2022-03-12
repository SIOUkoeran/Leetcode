import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.logging.XMLFormatter;

public class Main {
    static int N,M,H;
    static int[][][] map, dist;
    static int dx[]= {-1,1,0,0,0,0};
    static int dy[] = {0,0,-1,1,0,0};
    static int dz[] ={0,0,0,0,-1,1};
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        dist = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    dist[i][j][k] = -1;

                    if (map[i][j][k] == 1){
                        q.add(i); q.add(j); q.add(k);
                        dist[i][j][k] = 0;
                    }
                }
            }
        }
        solution();
    }
    static void solution(){
        bfs();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, dist[i][j][k]);
                }
            }
        }
        System.out.println(ans);
    }
    static void bfs(){
        while (!q.isEmpty()){
            int z = q.poll(); int y = q.poll(); int x = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N|| nz >= H) continue;
                if (dist[nz][ny][nx] != -1) continue;
                if (map[nz][ny][nx] != 0) continue;
                q.add(nz); q.add(ny); q.add(nx);
                map[nz][ny][nx] = 1;
                dist[nz][ny][nx] = dist[z][y][x] + 1;
            }
        }
    }
}
