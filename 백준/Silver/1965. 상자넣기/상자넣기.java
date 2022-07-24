import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N + 1];
    }
    static void solution() {
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++){
            for (int j = 1; j < i + 1; j++){
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);

        }

        System.out.println(max);
    }


}
