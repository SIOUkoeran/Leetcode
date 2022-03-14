import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static LinkedList<Integer>[] tree;
    static int weight[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new LinkedList[n + 1];
        weight = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new LinkedList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == -1){
                continue;
            }
            tree[temp].add(i);
        }
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            weight[node] += w;
        }
        solution();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(weight[i]).append(' ');
        }
        System.out.println(sb);
    }
    static void solution(){
        dfs(1);
    }
    static void dfs(int node){
        for (int y : tree[node]){
            weight[y] += weight[node];
            dfs(y);
        }
    }
}
