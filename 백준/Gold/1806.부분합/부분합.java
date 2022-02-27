import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,S;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    static void solution(){
        int high = 0, sum = 0, ans = N + 1;
        for (int low = 1; low < N + 1; low++) {
            sum -= nums[low - 1];
            while (high + 1 <= N && sum < S){
                high++;
                sum += nums[high];
            }

            if (sum >= S){
                ans = Math.min(ans, high - low + 1);
            }
        }
        if (ans == N + 1){
            ans = 0;
        }
        System.out.println(ans);
    }
}
