import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] coins, dp;
    public static void main(String[] args) throws IOException {

        input();
        solution();
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[10_001];
    }
    static void solution() {
        Arrays.fill(dp, 10_001);
        dp[0] = 0;
        for (int i = 0; i < n; i++){
            for (int j = coins[i]; j < k + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        int ans = dp[k] == 10_001 ? -1 : dp[k];
        System.out.println(ans);
    }
}
