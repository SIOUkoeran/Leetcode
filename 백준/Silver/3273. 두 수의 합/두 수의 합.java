

import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static int N, x, answer = 0;
    static int[] nums;
    static Set<Integer> list = new HashSet<>();
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
    }
    private static void solution() {
        binarySearch(x);
        System.out.println(answer);
    }
    private static void binarySearch(int target) {
        if (target < 0)
            return;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == x) {
                low++;
                high--;
                ++answer;
            }else if (sum < x) {
                low++;
            }else {
                high--;
            }
        }
    }
}
