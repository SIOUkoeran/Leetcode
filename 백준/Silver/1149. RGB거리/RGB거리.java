import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] rgb,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        rgb = new int[N + 1][3];
        dp = new int[N + 1][3];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            rgb[i][0] = red;
            rgb[i][1] = green;
            rgb[i][2] = blue;
        }
        solution();
    }
    static void solution(){
        dp[1][0] = rgb[1][0];
        dp[1][1] = rgb[1][1];
        dp[1][2] = rgb[1][2];
        int ans = Integer.MAX_VALUE;
        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + rgb[i][0], dp[i - 1][2] + rgb[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + rgb[i][1], dp[i - 1][2] + rgb[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + rgb[i][2], dp[i - 1][1] + rgb[i][2]);
        }
        for (int i = 0; i < 3; i++) {
            ans = Math.min(dp[N][i],ans);
        }
        System.out.println(ans);
    }
}
