import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, P, K;
    static LinkedList<Graph>[] graphs;
    static int[] answers;
    static class Graph implements Comparable<Graph>{
        int dest;
        int cost;
        public Graph(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Graph o) {
            return cost - o.cost;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        input();
        solution();
    }
    private static void solution(){
        int answer = -1, left = 0, right = 987654321;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean flag = dijkstra(mid);
            if (flag) {
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean dijkstra(int min) {
        PriorityQueue<Graph> q = new PriorityQueue<>();
        q.add(new Graph(1, 0));
        Arrays.fill(answers, 987654321);
        answers[1] = 0;
        while (!q.isEmpty()){
            Graph cur = q.poll();

            for (Graph next : graphs[cur.dest]) {
                int dest = next.dest;
                int cost = next.cost;
                int k = cost <= min ? 0 : 1;
                if (answers[dest] <= k + cur.cost) continue;

                answers[dest] = k + cur.cost;
                q.add(new Graph(dest,cur.cost + k));
            }
        }
        return answers[N] <= K;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graphs = new LinkedList[N + 1];
        for (int i = 1; i < N + 1; i++){
            graphs[i] = new LinkedList<>();
        }
        for (int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graphs[from].add(new Graph(to, cost));
            graphs[to].add(new Graph(from, cost));
        }
        answers = new int[N + 1];
    }
}

