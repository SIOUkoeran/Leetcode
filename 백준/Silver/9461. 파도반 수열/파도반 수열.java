import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,T;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++){
            input(br, st);
            solution();
        }
        System.out.println(sb);
    }
    static void input(BufferedReader br, StringTokenizer st) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new long[N + 1];
    }
    static void solution(){
        if (N < 5){
            if (N <= 3){
                sb.append(1).append('\n');
                return ;
            }else{
                sb.append(2).append('\n');
                return ;
            }
        }
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 6; i < N + 1; i++){
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        sb.append(dp[N]).append('\n');
    }
}
