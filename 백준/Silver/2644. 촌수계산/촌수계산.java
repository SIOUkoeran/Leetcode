import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int people1, people2;
    static Queue<Integer>[] q;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        people1 = Integer.parseInt(st.nextToken());
        people2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        q = new Queue[N + 1];
        for (int i = 1; i < N + 1; i++) {
            q[i] = new LinkedList<Integer>();
        }
        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int children = Integer.parseInt(st.nextToken());
            q[parent].add(children);
            q[children].add(parent);
        }
        solution();
    }
    static void solution(){
        bfs();
        System.out.println(dist[people2]);
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();;
        for (int i = 1; i < N + 1; i++) {
            dist[i] = -1;
        }
        queue.add(people1);
        dist[people1] = 0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for (int y : q[x]){
                if (dist[y] != - 1)continue;
                queue.add(y);
                dist[y] = dist[x] + 1;
            }
        }

    }
}
