import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,start,dest;
    static int[] dist;
    static LinkedList<Info>[] tree;
    static class Info{
        int dest;
        int cost;

        public Info(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        tree = new LinkedList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
            tree[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tree[start].add(new Info(dest,cost));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
        solution();
    }
    static void solution(){
        PriorityQueue<Info> q = new PriorityQueue<Info>(Comparator.comparing(o -> o.cost));
        q.add(new Info(start,0));
        dist[start] = 0;

        while (!q.isEmpty()){
            Info currentInfo = q.poll();
            if (dist[currentInfo.dest] < currentInfo.cost) continue;
            for (Info nextInfo : tree[currentInfo.dest]){
                if (nextInfo.cost + dist[currentInfo.dest] >= dist[nextInfo.dest]) continue;
                dist[nextInfo.dest] = Math.min(nextInfo.cost + dist[currentInfo.dest], dist[nextInfo.dest]);
                q.add(new Info(nextInfo.dest, dist[nextInfo.dest]));
            }
        }
        System.out.println(dist[dest]);
    }
}
