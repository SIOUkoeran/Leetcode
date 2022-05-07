import java.util.*;
import java.io.*;
public class Main {
	static int N,M,R;
	static int[][] map;
	static int score = 0;
	static String[] dir = {"E", "S", "W", "N"};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String d =  st.nextToken();
			solution(x,y,d);
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			pickone(x,y);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (map[i][j] > 0) {
					sb.append('S').append(' ');
				}
				else
					sb.append('F').append(' ');
			}
			sb.append('\n');
		}
		System.out.println(score);
		System.out.println(sb.toString());
	}
	
	static void pickone(int x, int y) {
		if (map[x][y] < 0)
			map[x][y] *= -1;
	}
	static void solution(int x, int y, String direction) {
		if (direction.equals("E")) {
			downE(x,y);
		}
		else if (direction.equals("S")) {
			downS(x,y);
			
		}
		else if (direction.equals("W")) {
			downW(x,y);
		}
		else if (direction.equals("N")) {
			downN(x,y);
		}
	}
	static void downW(int x, int y) {
		int temp = map[x][y];
		for (int i = y; i > 0; i--) {
			temp = Math.max(temp, map[x][i]);
			if (temp - 1 >= 0) {
				if (map[x][i] > 0) {
					map[x][i] *= -1;
					score++;
				}
			}
			temp--;
			if (temp == 0) {
				break;
			}
		}
	}
	static void downE(int x , int y) {
		int temp = map[x][y];
		for (int i = y; i < M + 1; i++) {
			temp = Math.max(temp, map[x][i]);
			if (temp - 1 >= 0) {
				if (map[x][i] > 0) {
					map[x][i] *= -1;
					score++;
				}
			}
			temp--;
			if (temp == 0) {
				break;
			}
		}
	}
	static void downS(int x, int y) {
		int temp = map[x][y];
		for (int i = x; i < N + 1; i++) {
			temp = Math.max(temp, map[i][y]);
			if (temp - 1 >= 0) {
				if (map[i][y] > 0) {
					map[i][y] *= -1;
					score++;
				}
			}
			temp--;
			if (temp == 0) {
				break;
			}
		}
	}
	static void downN(int x, int y) {
		int temp = map[x][y];
		for (int i = x; i > 0; i--) {
			temp = Math.max(temp, map[i][y]);
			if (temp - 1 >= 0){
				if (map[i][y] > 0) {
					map[i][y] *= -1;
					score++;
				}
			}
			temp--;
			if (temp == 0) {
				break;
			}
		}
	}
	
}
