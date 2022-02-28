import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, 1, N + 1);
        solution();

    }
    static void solution(){
        long sum = Long.MAX_VALUE;
        int n1 = 0,n2 = 0,n3 = 0;
        for (int i = 1; i < N - 1; i++) {
            int target = nums[i];
            int low = i + 1, high = N;
            while (low < high){
                if (sum > Math.abs((long) target + nums[low] + nums[high])){
                    sum = Math.abs((long) target + nums[low] + nums[high]);
                    n1 = target;
                    n2 = nums[low];
                    n3 = nums[high];
                }
                if (nums[low] + nums[high] > -target){
                    --high;
                }else{
                    ++low;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n1).append(' ').append(n2).append(' ').append(n3);
        System.out.println(sb);
    }
}
