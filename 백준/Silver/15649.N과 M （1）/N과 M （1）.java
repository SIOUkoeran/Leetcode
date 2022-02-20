import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static StringBuilder sb;
    private static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        selected = new int[M + 1];
        rec_fun(1);
        System.out.println(sb.toString());
    }
    private static void rec_fun(int k){
        boolean flag = false;
        if(k == M + 1){
            for (int i = 1; i < M + 1; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for (int i = 1; i < N + 1; i++) {
                flag = false;
                for (int j = 1; j < k; j++) {
                    if (i == selected[j]){
                        flag = true;
                    }
                }
                if (!flag){
                    selected[k] = i;
                    rec_fun(k + 1);
                }
            }
        }
    }
}
