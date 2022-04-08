import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        solution();
    }
    static void solution(){
        if (N == 1){
            System.out.println(3);
            return;
        }
        dp[1] = 3;
        dp[2] = 7;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i -2]) % 9901;
        }
        System.out.println(dp[N]);
    }

}
