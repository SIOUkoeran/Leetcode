import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N,M,ans;
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Point>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new LinkedList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new LinkedList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new Point(b,c));
            tree[b].add(new Point(a,c));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            solution(a,b);
        }
        System.out.println(sb);
    }
    static void solution(int a, int b){
        dfs(a,-1,b,0);
        sb.append(ans).append('\n');
    }
    static void dfs(int x, int pre, int des, int dist){
        if (x == des){
            ans = dist;
            return;
        }
        for (Point temp : tree[x]){
            int y = temp.x;
            int c = temp.y;
            if (y == pre) continue;
            dfs(y,x,des,dist + c);
        }
    }
}
