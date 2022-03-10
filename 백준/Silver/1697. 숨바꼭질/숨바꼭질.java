import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100000 + 1];
        dist = new int[100000 + 1];
        solution();
    }
    static void solution(){
        bfs();
        System.out.println(dist[K]);
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        visited[N] = true;
        dist[N] = 0;
        q.add(N);

        while (!q.isEmpty()){
            int currentPoint = q.poll();
            int nextPoint = currentPoint - 1;
            if (nextPoint >= 0 && nextPoint <= 100000 && !visited[nextPoint]){
                q.add(nextPoint);
                visited[nextPoint] = true;
                dist[nextPoint] = dist[currentPoint] + 1;
            }
            nextPoint = currentPoint + 1;
            if (nextPoint >= 0 && nextPoint <= 100000 && !visited[nextPoint]){
                q.add(nextPoint);
                visited[nextPoint] = true;
                dist[nextPoint] = dist[currentPoint] + 1;
            }
            nextPoint = currentPoint * 2;
            if (nextPoint >= 0 && nextPoint <= 100000 && !visited[nextPoint]){
                q.add(nextPoint);
                visited[nextPoint] = true;
                dist[nextPoint] = dist[currentPoint] + 1;
            }
        }
    }
}
