import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] child;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        child = new int[30][2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = (int) (st.nextToken().charAt(0) - 'A');
            for (int j = 0; j < 2; j++) {
                char ch = st.nextToken().charAt(0);
                if (ch == '.'){
                    child[cur][j] = -1;
                }else{
                    child[cur][j] = (int) (ch - 'A');
                }
            }
        }
        solution();
    }
    static void solution(){
        pre(0);
        sb.append('\n');
        in(0);
        sb.append('\n');
        post(0);
        System.out.println(sb);
    }
    static void pre(int x){
        if (x == -1)
            return;
        sb.append((char)(x + 'A'));
        pre(child[x][0]);
        pre(child[x][1]);
    }
    static void in(int x){
        if (x == -1)
            return;
        in(child[x][0]);
        sb.append((char)(x + 'A'));
        in(child[x][1]);
    }
    static void post(int x){
        if (x == -1)
            return;
        post(child[x][0]);
        post(child[x][1]);
        sb.append((char)(x + 'A'));
    }
}
