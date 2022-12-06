
import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
    static int n;
    static LinkedList<Integer>[] tempTree;
    static LinkedList<Integer>[] tree;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        tempTree = new LinkedList[n + 1];
        tree = new LinkedList[n + 1];
        dp = new int[n + 1][18];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n + 1; i++) {
            tempTree[i] = new LinkedList<>();
            tree[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tempTree[from].add(to);
            tempTree[to].add(from);
        }
    }


    private static void solution() {
        makeTree(1, -1);
        int max = Integer.MAX_VALUE;
        for (int i = 1; i < 18; i++) {
            max = Math.min(max, dfs(1, i));
        }
        System.out.println(max);
    }

    private static int dfs(int node, int color) {
        if (dp[node][color] != -1) return dp[node][color];

        dp[node][color] = 0;
        for (int next : tree[node]) {
            int tmp = Integer.MAX_VALUE;
            for (int i = 1; i < 18; i++) {
                if (color != i) {
                    tmp = Math.min(tmp, dfs(next, i));
                }
            }
            dp[node][color] += tmp;
        }
        return dp[node][color] += color;
    }


    private static void makeTree(int idx, int parent) {
        for (int next : tempTree[idx]) {
            if (next != parent) {
                tree[idx].add(next);
                makeTree(next, idx);
            }
        }
    }

}
