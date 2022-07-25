import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] vips, seats, dp;

    public static void main(String[] args) throws IOException{
        input();
        solution();
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        vips = new int[M];
        seats = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            vips[i] = Integer.parseInt(st.nextToken());
        }
        int vipsIdx = 0;
        for (int i = 1; i < N + 1; i++) {
            seats[i] = i;
            if (vips.length > 0 && vipsIdx < vips.length && seats[i] == vips[vipsIdx]){
                seats[i] = -1;
                ++vipsIdx;
            }
        }
    }
    static void solution() {
        dp[1] = 1; dp[0] = 1;
//        System.out.println(Arrays.toString(seats));
        for (int i = 2; i < N + 1; i++) {
            if (seats[i] < 0){
                dp[i] = dp[i - 1];
            }
            else if (seats[i - 1] < 0){
                dp[i] = dp[i - 1];
            }
            else if (seats[i - 2] < 0){
                dp[i] = dp[i - 1] * 2;
            }else{
                if (seats[i - 1] >= 0){
                    dp[i] = dp[i - 1] + dp[i - 2];
                }else{
                    dp[i] = dp[i - 1];
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}