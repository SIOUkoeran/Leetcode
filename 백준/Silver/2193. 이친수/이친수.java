import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new long[N + 1];
        solution();
    }
    static void solution(){
        dp[1] = 1;
        if (N == 1){
            System.out.println(dp[N]);
            return;
        }
        dp[2] = 1;
        if (N == 2) {
            System.out.println(dp[N]);
            return;
        }
        for (int i = 3; i < N + 1; i++) {
            dp[i]= dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[N]);
        /**
         * N
         * 1 1
         * 2 10
         * 3 100 101
         * 4 1000 1001 1010
         * 5 10001 10101 10100 10010 10000
         * 6 100000 101000 100100 100010 100001 101010 101001 100101
         */
    }
}
