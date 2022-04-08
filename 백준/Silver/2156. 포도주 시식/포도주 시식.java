import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] wine;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        wine = new int[N + 1];
        dp = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            wine[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    static void solution(){
        if (N == 1){
            System.out.println(wine[1]);
            return;
        }
        if (N == 2){
            System.out.println(wine[1] + wine[2]);
            return;
        }
        dp[1][0] = wine[1];
        dp[2][0] = wine[2];
        dp[2][1] = wine[1] + wine[2];
        int ans = 0;
        for (int i = 3; i < N + 1; i++) {
            dp[i][0] = Math.max(dp[i - 2][0] + wine[i], dp[i - 2][1] + wine[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + wine[i]);
        }
//        for (int i = 1; i < N + 1; i++) {
//            int temp = Math.max(dp[i][0], dp[i][1]);
//            ans = Math.max(temp, ans);
//        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
