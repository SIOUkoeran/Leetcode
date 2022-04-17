import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N][10];
        solution();
    }
    static void solution(){
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        if (N == 1)
        {
            System.out.println(10);
            return;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k >= 0; k--) {
                    dp[i][j] += dp[i - 1][k] % 10007;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N - 1][i];
        }
        System.out.println(ans % 10007);
    }
}
