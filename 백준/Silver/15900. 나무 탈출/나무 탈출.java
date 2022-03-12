import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N,cnt;
    static LinkedList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tree = new LinkedList[N  +1];
        cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new LinkedList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        solution();
    }
    static void solution(){
        dfs(1, -1, 0);
        if (cnt % 2 == 0)
            System.out.println("No");
        else
            System.out.println("Yes");
    }
    static void dfs(int start, int parent, int depth){
        if (start != 1 && tree[start].size() == 1){
            cnt += depth;
        }
        for (int y : tree[start]){
            if (y == parent){
                continue;
            }
            dfs(y, start, depth + 1);
        }
    }

}
