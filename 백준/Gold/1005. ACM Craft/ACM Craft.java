import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T,N,K,target;
    static LinkedList<Integer>[] tree;
    static int[] cost, indeg,done;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            tree = new LinkedList[N + 1];
            indeg = new int[N + 1];
            cost = new int[N + 1];
            done = new int[N + 1];
            for (int j = 0; j < N + 1; j++) {
                tree[j] = new LinkedList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int a = Integer.parseInt(st.nextToken());
                cost[j] = a;
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a].add(b);
                indeg[b]++;
            }
            st = new StringTokenizer(br.readLine());
            target = Integer.parseInt(st.nextToken());
            solution();

        }
    }
    static void solution(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indeg[i]== 0){
                q.add(i);
                done[i] = cost[i];
            }
        }
        while (!q.isEmpty()){
            int x = q.poll();
            for (int y : tree[x]){
                indeg[y]--;
                if (indeg[y] == 0){
                    q.add(y);
                }
                done[y] = Math.max(done[y], cost[y] + done[x]);
            }
        }
        System.out.println(done[target]);
    }
}
