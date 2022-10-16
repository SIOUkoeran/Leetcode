import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans = -1;
    static LinkedList<Integer>[] graph;
    static int[] cost;
    static int[][] sum;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new LinkedList[N + 1];
        cost = new int[N + 1];
        visited = new boolean[N + 1];
        sum = new int[N + 1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new LinkedList<Integer>();
            cost[i] = Integer.parseInt(st.nextToken());
//            Arrays.fill(sum[i], -1);
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }
    }

    private static void solution() {
        int ans = Math.max(dp(1, 0), dp(1, 1) + cost[1]);
        System.out.println(ans);
    }

    private static int dp(int start, int priorFlag) {
        if (sum[start][priorFlag] != 0)
            return sum[start][priorFlag];
        visited[start] = true;
        for (int to : graph[start]) {
            if (visited[to]) continue;
            if (priorFlag == 1) {
                sum[start][priorFlag] += dp(to, 0);
            }
            if (priorFlag == 0) {
                sum[start][priorFlag] += Math.max(dp(to, 0), dp(to, 1) + cost[to]);
            }
        }
        visited[start] = false;
        return sum[start][priorFlag];
    }
}
