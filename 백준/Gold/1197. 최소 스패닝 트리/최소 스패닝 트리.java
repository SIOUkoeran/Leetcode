
import java.awt.Point;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static class Info implements Comparable<Info>{
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
        @Override
        public String toString() {
            return "cost : " + this.cost;
        }
    }
    static int V,E;
    static Info[] infos;
    static int[] parents;
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(solution());
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        infos = new Info[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            infos[i] = new Info(from, to, cost);
        }
        parents = new int[V + 1];
        Arrays.fill(parents, -1);
    }

    private static int solution() {
        return kruskal();
    }
    private static int kruskal() {
        Arrays.sort(infos);
        int answer = 0;
        for (int i = 0; i < infos.length; i++) {
            Info cur = infos[i];
            int parent1 = findParent(cur.from);
            int parent2 = findParent(cur.to);
            if (parent1 != parent2) {
                answer += cur.cost;
                union(cur.from, cur.to);
            }
        }
        return answer;
    }

    private static int findParent(int x) {
        if (parents[x] == -1)
            return x;
        return parents[x] = findParent(parents[x]);
    }

    private static void union(int x, int y) {
        int parentX = findParent(x);
        int parentY = findParent(y);
        if (parentX != parentY)
            parents[parentY] = parentX;
    }
}
