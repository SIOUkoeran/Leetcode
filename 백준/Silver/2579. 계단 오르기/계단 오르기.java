import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] stairs;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        stairs = new int[N + 1];
        dp = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    static void solution(){
        if (N == 1){
            System.out.println(stairs[1]);
            return;
        }
        dp[1][0] = stairs[1];
        dp[2][0] = stairs[2];
        dp[2][1] = stairs[1] + stairs[2];
        for (int i = 3; i < N + 1; i++) {
            dp[i][0] = Math.max(dp[i - 2][1] + stairs[i], dp[i - 2][0] + stairs[i]);
            dp[i][1] = dp[i - 1][0] + stairs[i];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
