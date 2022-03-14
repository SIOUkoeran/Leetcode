import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static LinkedList<Integer>[] graph;
    static StringBuilder sb= new StringBuilder();
    static int[] Indeg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new LinkedList[N + 1];
        Indeg = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            Indeg[b]++;
        }
        solution();
    }
    static void solution(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (Indeg[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
           int x = q.poll();
           sb.append(x).append(' ');
           for (int y : graph[x]){
                Indeg[y]--;
                if (Indeg[y] == 0){
                    q.add(y);
                }
           }
        }
        System.out.println(sb);
    }
}
