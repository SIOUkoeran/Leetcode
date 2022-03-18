import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static LinkedList<Part>[] tree;
    static int[] indeg;
    static int[][] cost;
    static class Part{
        int y;
        int k;

        public Part(int y, int k) {
            this.y = y;
            this.k = k;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N + 1][N + 1];
        indeg = new int[N + 1];
        tree= new LinkedList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new LinkedList<>();
        }
        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            tree[y].add(new Part(x,k));
            indeg[x]++;
        }
        solution();
    }
    static void solution(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indeg[i] == 0){
                q.add(i);
                cost[i][i] = 1;
            }
        }
        while (!q.isEmpty()){
            int x = q.poll();
            for (Part part : tree[x]){
                indeg[part.y]--;
                for (int i = 1; i < N + 1 ; i++) {
                    cost[part.y][i] += cost[x][i] * part.k;
                }
                if (indeg[part.y] == 0){
                    q.add(part.y);
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if (cost[N][i] == 0) continue;
            System.out.println(i + " " + cost[N][i]);
        }
    }
}
