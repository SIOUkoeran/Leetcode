import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static  int N;
    private static  int M;
    private static  StringBuilder sb;
    private static  int[] selected;
    private static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = 0;
        sb = new StringBuilder();
        selected = new int[M + 1];
        rec_fun(1);
        System.out.println(sb.toString());
    }
    static void rec_fun(int k){
        if (k == M + 1){
            for (int i = 1; i < M + 1; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for (int i = selected[k - 1] + 1; i < N + 1; i++) {
                if (start >= i){
                    continue;
                }
                selected[k] = i;
                rec_fun(k + 1);
                selected[k] = 0;
            }
        }
    }
}
