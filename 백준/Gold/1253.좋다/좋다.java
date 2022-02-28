import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int ans = 0;
        Arrays.sort(nums, 1, N + 1);
        for (int i = 1; i < N + 1; i++) {
            if (solution(i)){
                ans++;
            }
        }
        System.out.println(ans);
    }
    static boolean solution(int targetIdx){
        int low = 1, high = N;
        int target = nums[targetIdx];
        while (low < high){
            if (low == targetIdx){
                low++;
            }else if (high == targetIdx){
                high--;
            }else{
                if (nums[low] + nums[high] == target){
                    return true;
                }
                if (nums[low] + nums[high] > target){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return false;
    }
}
