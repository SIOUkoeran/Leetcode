import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v,n,k;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            graph[vertex].add(node);
            graph[node].add(vertex);
        }
        for (int i = 1; i < v + 1; i++) {
            Collections.sort(graph[i]);
        }
        solution();
    }
    static void solution(){
        visited = new int[v + 1];
        dfs(k);
        sb.append('\n');
        visited = new int[v + 1];
        bfs(k);
        System.out.println(sb);
    }
    static void dfs(int x){
        visited[x] = 1;
        sb.append(x).append(' ');
        for (int node : graph[x]){
            if (visited[node] == 1)
                continue;
            dfs(node);
        }
    }
    static void bfs(int x){
        int[] visited = new int[v + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = 1;
        while (!q.isEmpty()){
            int v = q.poll();
            sb.append(v).append(' ');
            for (int y : graph[v]){
                if (visited[y] == 1)
                    continue;
                q.add(y);
                visited[y] = 1;
            }
        }
    }
}
