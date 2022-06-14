import java.io.*;
import java.util.*;



public class Main {
	static int N,M,S,E;
	static int numbers[];
	static boolean dp[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		numbers = new int[N + 1];
		dp = new boolean[N + 1][N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		solution();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if (dp[S][E])
				sb.append('1').append('\n');
			else
				sb.append('0').append('\n');
		}
		System.out.println(sb);
	}
	static void solution() {
		
		for (int i = 1; i < N; i++) {
			dp[i][i] = true;
			if (numbers[i] == numbers[i + 1]) {
				dp[i][i + 1] = true;
			}
		}
        dp[N][N] = true;
		for (int i = N - 1; i >= 1; i--) {
			for (int j = i + 2; j < N + 1; j++) {
				if (numbers[i] == numbers[j] && dp[i + 1][j - 1]) {
					dp[i][j] = true;
				}
			}
		}
		
	}

}