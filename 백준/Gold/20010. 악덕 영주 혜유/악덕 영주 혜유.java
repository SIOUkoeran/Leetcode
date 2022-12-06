import java.util.*;
import java.awt.Point;
import java.io.*;
import javax.sound.sampled.Line;

public class Main {
    private static class Info implements Comparable<Info>{
        int from;
        int to;
        int cost;
        public Info(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return this.cost - o.cost;
        }
    }
    static int n,k, second, distance;
    static LinkedList<Info>[] graph;
    static Info[] temp;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new LinkedList[k];
        parent = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        temp = new Info[k];

        for (int i = 0; i < k; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            temp[i] = new Info(from, to, cost);
        }
        Arrays.sort(temp);

    }

    private static void solution() {
        int firstAnswer = kruskal();

        distance = -1;
        visited[0] = true;
        dfs(0, 0);
        
        Arrays.fill(visited, false);

        distance = -1;
        visited[second] = true;
        dfs(second, 0);
        int secondAnswer = distance;
        System.out.println(firstAnswer);
        System.out.println(secondAnswer);
    }

    private static void dfs(int cur, int sum) {
        if (distance < sum) {
            distance = sum;
            second = cur;
        }

        for (Info next : graph[cur]) {
            if (!visited[next.to]) {
                visited[next.to] = true;
                dfs(next.to, sum + next.cost);
            }
        }
    }

    private static int kruskal() {
        int result = 0;
        for (int i = 0; i < k; i++) {
            Info cur = temp[i];

            int p1 = findParent(cur.from);
            int p2 = findParent(cur.to);

            if (p1 != p2) {
                union(p1, p2);
                graph[cur.from].add(cur);
                graph[cur.to].add(new Info(cur.to, cur.from, cur.cost));
                result += cur.cost;
            }
        }
        return result;
    }

    private static void union(int a, int b) {
        if (a == b)
            return;
        parent[a] = b;
    }

    private static int findParent(int x) {
        if (parent[x] == x || parent[x] == -1)
            return x;
        int parentX = findParent(parent[x]);
        return parent[x] = parentX;
    }

}
