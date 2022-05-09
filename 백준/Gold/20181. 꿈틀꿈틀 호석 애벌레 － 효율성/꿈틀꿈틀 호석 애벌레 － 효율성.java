import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static long dp[],map[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new long[N + 1];
        map = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {

            map[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    static void solution() {
        long temp = 0, prior = 0;
        int j = 1;
        for (int i = 1; i < N + 1; i++) {
            prior = Math.max(prior, dp[i - 1]);
            while (temp < K && j < N + 1) {
                temp += map[j];
                j++;
            }
            if (temp >= K) {
                dp[j - 1] = Math.max(prior + temp - K, dp[j - 1]);
            }
            else
                break;
            temp -= map[i];
        }
        long ans = 0;
        for (int i = 1; i < N + 1; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}

