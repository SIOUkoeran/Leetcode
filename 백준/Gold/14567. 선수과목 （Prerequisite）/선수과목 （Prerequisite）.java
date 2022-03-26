import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static LinkedList<Integer>[] tree;
    static int[] indeg, dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new LinkedList[N + 1];
        dist = new int[N + 1];
        indeg = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new LinkedList<>();
        }
        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            indeg[y]++;
        }
        solution();
    }
    static void solution(){
        Queue<Integer>  q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indeg[i] == 0){
                q.add(i);
                dist[i] = 1;
            }
        }

        while (!q.isEmpty()){
            int x = q.poll();

            for (int y : tree[x]){
                indeg[y]--;
                if (indeg[y] == 0){
                    dist[y] = Math.max(dist[x] + 1, dist[y]);
                    q.add(y);
                }
            }
        }
        print();
    }
    static void print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(dist[i]).append(' ');
        }
        System.out.println(sb);
    }
}
