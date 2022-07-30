import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,L,R, mod = 1000000007;
    static long[][][] dp;
    public static void main(String[] args) throws IOException{
        input();
        solution();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        dp = new long[N + 1][N + 1][N + 1];
    }
    static void solution(){
        dp[1][1][1] = 1;
        if (N == 1){
            System.out.println(dp[1][1][1]);
            return;
        }
        dp[2][1][2] = 1;
        dp[2][2][1] = 1;

        for (int i = 3; i < N + 1; i++){
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    dp[i][j][k] = (dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + dp[i - 1][j][k] * (i - 2)) % mod;
                }
            }
        }
        System.out.println(dp[N][L][R]);
    }

}