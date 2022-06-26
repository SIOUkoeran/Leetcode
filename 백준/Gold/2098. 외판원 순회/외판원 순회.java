import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] W, dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dist = new int[N][(1 << N) - 1];
        for (int i = 0; i < N; i++){
            Arrays.fill(dist[i], -1);
        }
        solution();
    }
    static void solution(){
        System.out.println(dfs(0, 1));
    }
    static int dfs(int cur, int set){
        if (set == (1 << N) - 1){
            if (W[cur][0] == 0) return 987654321;
            return W[cur][0];
        }
        if (dist[cur][set] != -1)
            return dist[cur][set];
        dist[cur][set] = 987654321;
        for (int i = 0; i < N; i++){
            if ((set & (1 << i)) == 0 && W[cur][i] != 0){
                dist[cur][set] = Math.min(dist[cur][set], dfs(i, set | (1 << i)) + W[cur][i]);
            }
        }
        return dist[cur][set];
    }
    static boolean isVisited(int set, int idx){
        return ((set & (1 << idx)) == 0);
    }
}