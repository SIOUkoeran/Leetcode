import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dp, minDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][3];
        dp = new int[3];
        minDp = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
    }
    static void solution() {
        dp[0] = arr[0][0];
        dp[1] = arr[0][1];
        dp[2] = arr[0][2];
        minDp[0] = arr[0][0];
        minDp[1] = arr[0][1];
        minDp[2] = arr[0][2];
        if (N == 1){
            System.out.print(Math.max(arr[0][2], Math.max(arr[0][0], arr[0][1])) + " ");
            System.out.print(Math.min(arr[0][2], Math.min(arr[0][0], arr[0][1])));
            return;
        }
        for (int i = 1; i < N; i++) {
            int temp0 = Math.max(arr[i][0] + dp[0], arr[i][0] + dp[1]);
            int temp1 = Math.max(Math.max(arr[i][1] + dp[0], arr[i][1] + dp[1]), arr[i][1] + dp[2]);
            int temp2 = Math.max(arr[i][2] + dp[2], arr[i][2] + dp[1]);

            dp[0] = temp0;
            dp[1] = temp1;
            dp[2] = temp2;

            temp0 = Math.min(arr[i][0] + minDp[0], arr[i][0] + minDp[1]);
            temp1 = Math.min(Math.min(arr[i][1] + minDp[1], arr[i][1] + minDp[0]), arr[i][1] + minDp[2]);
            temp2 = Math.min(arr[i][2] + minDp[1], arr[i][2] + minDp[2]);

            minDp[0] = temp0;
            minDp[1] = temp1;
            minDp[2] = temp2;
        }
        System.out.print(Math.max(Math.max(dp[0], dp[1]), dp[2]) + " ");
        System.out.print(Math.min(Math.min(minDp[0], minDp[1]), minDp[2]));
    }
}
