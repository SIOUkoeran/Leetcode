import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N,erasedNode,root;
    static LinkedList<Integer>[] tree;
    static int[] leaf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tree = new LinkedList[N];
        leaf = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new LinkedList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1){
                root = i;
                continue;
            }
            tree[a].add(i);
        }
        st = new StringTokenizer(br.readLine());
        erasedNode = Integer.parseInt(st.nextToken());
        solution();
    }
    static void solution(){
        for (int i = 0; i < N; i++) {
            if (tree[i].contains(erasedNode)){
                tree[i].remove(tree[i].indexOf(erasedNode));
            }
        }
        if (root != erasedNode){
            dfs(root);
        }
        System.out.println(leaf[root]);
    }
    static void dfs(int start){
        if (tree[start].isEmpty()){
            leaf[start] = 1;
        }
        for (int y : tree[start]){
            dfs(y);
            leaf[start] += leaf[y];
        }
    }
}
