import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, K,M,P;
    static LinkedList<Integer>[] river;
    static int[] Indeg,dist,cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            river = new LinkedList[M + 1];
            Indeg = new int[M + 1];
            dist = new int[M + 1];
            cnt = new int[M + 1];
            for (int i = 0; i < M + 1; i++) {
                river[i] = new LinkedList<>();
            }
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                river[a].add(b);
                Indeg[b]++;
            }
            solution();

        }
    }
    static void solution(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < M + 1; i++) {
            if (Indeg[i] == 0){
                q.add(i);
                dist[i] = 1;
                cnt[i] = 1;
            }
        }
        int ans = 0;
        while (!q.isEmpty()){
            int x = q.poll();
            if (cnt[x] >= 2) dist[x]++;
            ans = Math.max(ans, dist[x]);
            for (int y : river[x]){
                Indeg[y]--;
                if (Indeg[y] == 0){
                    q.add(y);
                }
                if (dist[y] == dist[x]){
                    cnt[y]++;
                }else if (dist[y] < dist[x]){
                    dist[y] = dist[x];
                    cnt[y] = 1;
                }

            }
        }
        System.out.println(K + " " + ans);
    }
}
