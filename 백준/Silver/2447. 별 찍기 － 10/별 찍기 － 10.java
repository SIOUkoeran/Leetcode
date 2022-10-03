
import java.io.*;
import java.util.*;
public class Main {

	static int N;
	static boolean[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		input();
		solution();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new boolean[N][N];
	}
	
	private static void solution() {
		divide(0, 0, N);
		printStar();
	}
	
	private static void divide(int n, int m, int size) {
		
		if (size == 1) {
			map[n][m] = true;
			return;
		}
		
		int nextSize = size / 3;
		int cnt = 0;
		for (int i = n; i < n + size; i += nextSize) {
			for (int j = m; j < m + size; j += nextSize) 
			{
				if (++cnt == 5) {
					continue;
				}else {
					divide(i, j, nextSize);
				}
			}
		}
		
	}
	
	private static void printStar() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == false) sb.append(" ");
				else sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(String.valueOf(sb));
	}
}
