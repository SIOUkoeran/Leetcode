import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            sum += map[i];
        }

        init(sum);
        System.out.println(solution(0,map[0]));
    }
    static long solution(int idx, int sum){
        if (sum < 0 || sum > 20)
            return 0;

        if (idx == N - 2){
            if (sum == map[N - 1])
                return 1;
            return 0;
        }

        if (dp[sum][idx] != -1){
            return dp[sum][idx];
        }
        dp[sum][idx] = 0;
        return dp[sum][idx] += solution(idx + 1, sum + map[idx + 1]) + solution(idx + 1, sum - map[idx + 1]);

    }
    static void init(int sum){
        dp = new long[21][100];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 100; j++) {
                dp[i][j] = -1;
            }
        }
    }
}
