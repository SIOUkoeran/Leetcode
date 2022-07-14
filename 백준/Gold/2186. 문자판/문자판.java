import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main{
	static int N,M,K;
	static char[][] map;
	static String keyword;
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][][] dp;
	static class Info{
		int length;
		int x;
		int y;
		public Info(int length, int x, int y) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		keyword = st.nextToken();
		dp = new int[M][N][keyword.length()];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		solution();
	}
	static void solution() {
		int answer = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == keyword.charAt(0)) {
					dfs(0, i, j);
					answer += dp[i][j][0];
				}
			}
		}
		System.out.println(answer);
	}
	static void dfs(int idx, int x, int y) {
		if (idx == keyword.length() - 1) {
			dp[x][y][idx] = 1;
			return ;
		}
		if (dp[x][y][idx] != -1)
			return ;
		dp[x][y][idx] = 0;
		for (int i = 1; i <= K; i++) {
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j] * i;
				int ny = y + dy[j] * i;
				if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if (map[nx][ny] == keyword.charAt(idx + 1)) {
						dfs(idx + 1, nx, ny);
						dp[x][y][idx] += dp[nx][ny][idx + 1];
					}
				}
			}
		}
	}
}