import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int ans = 0;
    static int[] children, dp;

    public static void main(String[] args) throws IOException{
        input();
        solution();
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        children = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            children[i] = Integer.parseInt(st.nextToken());
        }
    }
    static void solution() {
        int max = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (children[i] > children[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(N - max);
    }


}
