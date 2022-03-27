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
            System.out.println(1);
            return;
        }
        if (N == 2){
            System.out.println(2);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < N + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }
        System.out.println(dp[N]);
    }
}
