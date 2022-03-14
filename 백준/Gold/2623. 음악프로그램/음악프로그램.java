import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static LinkedList<Integer>[] graph;
    static int[] Indeg;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new LinkedList[N + 1];
        Indeg = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int prev= Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt - 1; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (graph[prev].contains(temp)){
                    prev = temp;
                    continue;
                }
                graph[prev].add(temp);
                Indeg[temp]++;
                prev= temp;
            }
        }
        solution();
        System.out.println(sb);
    }
    static void solution(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (Indeg[i] == 0) {
                q.add(i);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (!q.isEmpty()){
            int x = q.poll();
            list.add(x);
            for (int y : graph[x]){
                Indeg[y]--;
                if (Indeg[y] == 0){
                    q.add(y);
                }
            }
        }
        if (list.size() == N){
            for (int x : list){
                sb.append(x).append('\n');
            }
        }
        else{
            sb.append(0);
        }
    }
}
