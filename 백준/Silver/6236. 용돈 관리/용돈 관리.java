

import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, maxNum;
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
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        maxNum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, nums[i]);
        }
    }
    private static void solution() {
        binarySearch();
    }
    private static void binarySearch() {
        long answer = 0;
        long low = maxNum;
        long high = 1000000000;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (isPay((int) mid) > M) {
                low = mid + 1;
            }else {
                answer = mid;
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
    private static int isPay(int money) {
        int sum = 0, cnt = 1;
        for (int i = 0; i < N; i++) {
            if (nums[i] + sum > money) {
                sum = nums[i];
                ++cnt;
            }else {
                sum += nums[i];
            }
        }
        return cnt;
    }
}
