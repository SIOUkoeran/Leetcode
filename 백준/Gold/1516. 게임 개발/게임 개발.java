import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static LinkedList<Integer>[] tree;
    static int[] cost,indeg,done;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tree = new LinkedList[N + 1];
        cost = new int[N + 1];
        indeg = new int[N + 1];
        done = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new LinkedList<>();
        }
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()){
                int a = Integer.parseInt(st.nextToken());
                if (a == -1)
                    continue;
                tree[a].add(i);
                indeg[i]++;
            }
        }
        solution();
        System.out.println(sb);
    }
    static void solution(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indeg[i] == 0){
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
                done[y] = Math.max(done[y], done[x] + cost[y]);
            }
        }
        for (int i = 1; i < N + 1; i++) {
            sb.append(done[i]).append('\n');
        }
    }
}
