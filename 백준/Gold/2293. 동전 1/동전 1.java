import java.io.*;
import java.util.*;

public class Main{
	static int n, k;
	static int[] coins;
	static int[] dp;
	public static void main(String[] args) throws IOException{
        input();
		solution();
	}
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coins = new int[101];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coins[i + 1] = Integer.parseInt(st.nextToken());
		}
	}
	static void solution() {
		dp = new int[100001];
		dp[0] = 1; 
		for (int i = 1; i < n + 1; i++) {
			for (int j = coins[i]; j < k + 1; j++) {
				dp[j] = dp[j] + dp[j - coins[i]]; 
			}
		}
		System.out.println(dp[k]);
	}
}