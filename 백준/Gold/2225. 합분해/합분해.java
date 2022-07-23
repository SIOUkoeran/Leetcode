import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;

    static long[][] dp;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new long[N + 1][K + 1];
    }
    static  void solution() {
        for (int i = 1; i < N + 1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i < K + 1; i++){
            dp[1][i] = i;
        }
        for (int i = 2; i < N + 1; i++){
            for (int j =2; j < K + 1; j++) {
                dp[i][j] += (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }
        System.out.print(dp[N][K]);
    }


}
