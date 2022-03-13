import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n,k,ans;
    static int[] node, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int root = 0;
        while (true){
            ans = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0){
                return;
            }
            node = new int[n + 1];
            parent = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                int temp = Integer.parseInt(st.nextToken());
                node[i] = temp;
            }
            solution();
        }
    }
    static void solution(){
        inputParent();
        dfs();
    }
    static void inputParent(){
        parent[0] = -1;
        parent[1] = 0;

        int prev = 1;
        for (int i = 2; i < n + 1; i++, prev++) {
            for (; i < n + 1; i++) {
                parent[i] = prev;
                if (i < n && node[i] + 1 != node[i + 1]) break;
            }
        }
    }
    static void dfs(){
        int idx = 0;
        for (int i = 1; i < n + 1; i++) {
            if (node[i] == k)
                idx = i;
        }
        for (int i = 1; i < n + 1; i++) {
            if (parent[parent[i]] == parent[parent[idx]] && parent[i] != parent[idx]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
