import java.awt.Point;

import java.io.*;
import java.util.*;



public class Main {
	static int N,M,sum;
	static int[] active, deactive;
	static int dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = 0;
		active = new int[N + 1];
		deactive = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			active[i] = Integer.parseInt(st.nextToken());
		}	
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			deactive[i] = Integer.parseInt(st.nextToken());
			sum += deactive[i];
		}
		solution();
	}
	static void solution() {
		int ans = 0;
		dp = new int[sum + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = sum; j >= deactive[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - deactive[i]] + active[i]);
			}
		}
		
		for (int i = sum; i > 0; i--) {
			if (dp[i] >= M) {
				ans = i;
			}
			else {
				break;
			}
		}
		System.out.println(ans);
 	}
}