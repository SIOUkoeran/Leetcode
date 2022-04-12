import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            dp = new long[N + 1][11];
            solution();
        }
        System.out.println(sb);
    }

    static void solution(){
        for (int i = 1; i <= 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j <= 10 ; j++) {
                for (int k = j; k <= 10 ; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        long ans = 0;
        for (int i = 1; i < 11; i++) {
            ans += dp[N][i];
        }
        sb.append(ans).append('\n');
    }
}
