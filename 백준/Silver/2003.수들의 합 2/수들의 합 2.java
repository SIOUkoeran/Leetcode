import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    static void solution(){
        int high = 0,ans = 0, sum = 0;
        for (int low = 1; low < nums.length; low++) {
            sum -= nums[low - 1];
            while(high < nums.length && sum < M){
                sum += nums[high];
                high++;
            }
            if (sum == M){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
