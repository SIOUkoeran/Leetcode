import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] indeg;
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new LinkedList[N + 1];
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
        System.out.println(sb);
    }
    static void solution(){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()){
            int x = q.poll();
            sb.append(x).append(' ');
            for (int y : tree[x]){
                indeg[y]--;
                if (indeg[y] == 0){
                    q.offer(y);
                }
            }
        }
    }
}
