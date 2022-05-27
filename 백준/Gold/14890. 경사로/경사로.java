import java.io.*;
import java.util.*;

public class Main {
	static int N,L,ans;
	static int map[][];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ans = N * 2;
			map = new int[N][N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j =0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solution();
			System.out.println(ans);
	}
	private static void solution() {
		for (int i = 0; i < N; i++) {
			checkRow(i);
			checkCol(i);
		}
		
	}
	private static void checkCol(int i) {
		Arrays.fill(visited, false);
		for (int j = 0; j < N - 1; j++) {
			if (map[j][i] == map[j + 1][i])
				continue;
			else if (map[j][i] - map[j + 1][i] == 1) {
				for (int k = j + 1; k <= j + L; k++) {
					if (k >= N || visited[k] || map[j + 1][i] != map[k][i]) {
						--ans;
						return;
					}
					visited[k] = true;
				}
			}
			else if (map[j][i] - map[j + 1][i] == -1) {
				for (int k = j; k > j - L; k--) {
					if ( k < 0 || visited[k] || map[j][i] != map[k][i]) {
						--ans;
						return;
					}
					visited[k] = true;
				}
			}
			else {
				ans--;
				return;
			}
		}
	}
	private static void checkRow(int i) {
			Arrays.fill(visited, false);
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] == map[i][j + 1])
					continue;
				else if (map[i][j] - map[i][j + 1] == 1) {
					for (int k = j + 1; k <= j + L; k++) {
						if (k >= N || visited[k]|| map[i][k] != map[i][j + 1]) {
							--ans;
							return;
						}
						visited[k] = true;
					}
				}
				else if (map[i][j] - map[i][j + 1] == -1) {
					for (int k = j; k > j - L; k--) {
						if (k < 0  || visited[k] || map[i][k] != map[i][j]) {
							--ans;
							return;
						}
						visited[k] = true;
					}
				}
				else {
					--ans;
					return;
				}
			}
	}
}
