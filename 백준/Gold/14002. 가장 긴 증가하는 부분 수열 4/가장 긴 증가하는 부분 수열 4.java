import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		solution();
	}
	static void solution() {
		int[] dp = new int[N];
		dp[0] = 1;
		int temp = 0, maxIdx = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			if (temp < dp[i]) {
				maxIdx = i;
				temp = dp[i];
			}
		}
		System.out.println(temp);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = maxIdx; i >= 0; i--) {
			if (temp == dp[i]) {
				linkedList.add(nums[i]);
				temp--;
			}
		}
		while (linkedList.size() > 0) {
			System.out.print(linkedList.pollLast() + " ");
		}
	}
}