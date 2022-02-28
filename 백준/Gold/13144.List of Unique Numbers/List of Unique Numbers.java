import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        cnt = new int[100000 + 1];
        solution();

    }
    static void solution(){
        long ans = 0;
        int high = 0;
        for (int low = 1; low < N + 1; low++) {
            while (high < N && cnt[nums[high + 1]] == 0){
                high++;
                cnt[nums[high]]++;
            }
            ans += high - low + 1;
            cnt[nums[low]]--;
        }
        System.out.println(ans);
    }
}
