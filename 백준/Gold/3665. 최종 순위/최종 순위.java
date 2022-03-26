import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T,N,M;
    static int[] lastYear,indeg;
    static LinkedList<Integer>[] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            lastYear = new int[N + 1];
            tree = new LinkedList[N + 1];
            indeg = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                lastYear[j] = Integer.parseInt(st.nextToken());
                tree[j] = new LinkedList<>();
            }
            for (int j = 1; j < N + 1; j++) {
                for (int k = j + 1; k < N + 1; k++) {
                    tree[lastYear[j]].add(lastYear[k]);
                    indeg[lastYear[k]]++;
                }
            }

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (tree[x].contains(y)){
                    tree[x].remove((Integer) y);
                    tree[y].add(x);
                    indeg[x]++;
                    indeg[y]--;
                }else{
                    tree[y].remove((Integer) x);
                    tree[x].add(y);
                    indeg[y]++;
                    indeg[x]--;
                }
            }
            solution();
            System.out.println(sb);
            sb.setLength(0);
        }

    }
    static void solution(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indeg[i] == 0){
                queue.add(i);
            }
        }

        if (queue.size() > 1){
            sb.append("?");
        }
        for(int i=1;i<=N;i++) {
            if(queue.isEmpty()) {
                sb.setLength(0);
                sb.append("IMPOSSIBLE");
                break;
            }
            int x = queue.poll();
            sb.append(x).append(" ");
            for(int y : tree[x]) {
                indeg[y]--;
                if(indeg[y]==0){
                    queue.add(y);
                }
            }
        }
    }
}
