import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
    }
    static void solution() {
        if (N == 1){
            System.out.println(0);
            return ;
        }
        dp[2] = 3;
        for (int i = 4; i < N + 1; i += 2){
            dp[i] = dp[i - 2] * dp[2];
            for (int j = i - 4; j >= 2; j-= 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] += 2;
        }
        System.out.println(dp[N]);
    }
}
