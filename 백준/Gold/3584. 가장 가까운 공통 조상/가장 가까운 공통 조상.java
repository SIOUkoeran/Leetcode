import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N,node,A,B;
    static int[] parentNode;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            parentNode = new int[node + 1];
            visited = new boolean[node + 1];

            for (int j = 1; j < node; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parentNode[b] = a;
            }
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            solution();
        }

    }
    static void solution(){
        dfs(A);
        checkBfs(B);

    }
    static void dfs(int x){
       while (x > 0){
           visited[x] = true;
           x = parentNode[x];
       }
    }
    static void checkBfs(int x){
        while (x > 0 && !visited[x]){
            x = parentNode[x];
        }
        System.out.println(x);
    }
}
