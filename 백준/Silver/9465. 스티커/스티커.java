import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T,N;
    static int[][] stickers, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            stickers = new int[N + 1][2];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                stickers[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                stickers[j][1] = Integer.parseInt(st.nextToken());
            }
            solution();
        }

    }
    static void solution(){
        dp = new int[N + 1][2];
        dp[1][0] = stickers[1][0];
        dp[1][1] = stickers[1][1];
        if (N == 1){
            System.out.println(Math.max(dp[1][0], dp[1][1]));
            return;
        }
        dp[2][0] = dp[1][1] + stickers[2][0];
        dp[2][1] = dp[1][0] + stickers[2][1];
        for (int i = 3; i < N + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + stickers[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + stickers[i][1];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
