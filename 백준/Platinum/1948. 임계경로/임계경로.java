import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Road{
        int to;
        int cost;

        public Road(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static int N,M,start,dest;
    static int[] indeg, total;
    static boolean[] visited;
    static LinkedList<Road>[] tree,inverseTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        tree = new LinkedList[N + 1];
        inverseTree = new LinkedList[N  +1];
        indeg = new int[N + 1];
        visited = new boolean[N  + 1];
        total = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new LinkedList<>();
            inverseTree[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            tree[x].add(new Road(y,z));
            inverseTree[y].add(new Road(x,z));
            indeg[y]++;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
        solution();
    }
    static void solution(){
        calculateTime();
        calculateRoad();
    }
    static void calculateTime(){
        Queue<Road> q = new LinkedList<>();
        q.add(new Road(start,0));
        while (!q.isEmpty()){
            Road currentRoad = q.poll();
            int x = currentRoad.to;
            if (x == dest){
                break;
            }
            for (Road y : tree[x]){
                total[y.to] = Math.max(total[y.to], total[x] + y.cost);
                indeg[y.to]--;
                if (indeg[y.to] == 0){
                    q.add(new Road(y.to, total[y.to]));
                }
            }
        }
        System.out.println(total[dest]);
    }
    static void calculateRoad(){
        Queue<Road> q = new LinkedList<>();
        q.add(new Road(dest, total[dest]));
        int ans = 0;

        while (!q.isEmpty()){
            Road currentRoad = q.poll();
            if (visited[currentRoad.to]) continue;
            visited[currentRoad.to] = true;
            if (currentRoad.to == start) break;
            for (Road y : inverseTree[currentRoad.to]){
                if (currentRoad.cost - y.cost == total[y.to]){
                    ans++;
                    q.add(new Road(y.to, currentRoad.cost - y.cost));
                }
            }
        }
        System.out.println(ans);
    }
}
