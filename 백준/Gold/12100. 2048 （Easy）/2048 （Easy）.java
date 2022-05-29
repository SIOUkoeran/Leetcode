import java.io.*;
import java.util.*;

public class Main {
	static int N,max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solution(map);
	}
	public static void solution(int[][] map) {
		brute(0, map);
		
		System.out.println(max);
	}
	private static void brute(int cnt,int [][] map) {
		if (cnt == 5) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int [][] copyMap = new int[N][N];
			for (int idx = 0; idx < N; idx++) {
				System.arraycopy(map[idx], 0, copyMap[idx],0, N);
			}
			brute(cnt + 1, rotate(i, copyMap));
		}
	}
	
	
	private static int[][] rotate(int dir, int[][] map) {
		if (dir == 0) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					map = move0WhenDirEqual0(map, i,j);
					map = moveMap(map, i,j,i + 1, j);
				}
			}
		}else if (dir == 1) {
			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < N; j++) {
					map = move0WhenDirEqual1(map, i, j);
					map = moveMap(map, i, j, i - 1, j);	
				}
			}
			
		}else if (dir == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					map = move0WhenDirEqual2(map, i, j);
					map = moveMap(map, i, j, i, j + 1);
				}
			}
			
		}else if (dir == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > 0; j--) {
					map = move0WhenDirEqual3(map, i, j);
					map = moveMap(map, i, j, i, j - 1);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int temp = Arrays.stream(map[i]).max().getAsInt();
			if (max < temp) {
				max = temp;
			}
		}
		return map;
	}
	
	private static int[][] moveMap(int[][] map, int row, int col, int moveRow, int moveCol){
		
		if (map[row][col] == map[moveRow][moveCol] || map[row][col] == 0) {
			map[row][col] = map[moveRow][moveCol] + map[row][col];
			map[moveRow][moveCol] = 0;
		}
		return map;
	}
	
	private static int[][] move0WhenDirEqual0(int[][] map, int row, int col){
		for (int i = row; i < N - 1; i++) {
			if (map[i][col] == 0) {
				int tempRow = i + 1;
				while (tempRow < N - 1 && map[tempRow][col] == 0)
					tempRow++;
				map[i][col] = map[tempRow][col];
				map[tempRow][col] = 0;
			}
		}
		return map;
	}
	private static int[][] move0WhenDirEqual1(int[][] map, int row, int col){
		
		for (int i = row; i > 0; i--) {
			if (map[i][col] == 0) {
				int tempRow = i - 1;
				while (tempRow > 0 && map[tempRow][col] == 0)
					tempRow--;
				map[i][col] = map[tempRow][col];
				map[tempRow][col] = 0;
			}
		}
		return map;
	}
	
	private static int[][] move0WhenDirEqual2(int [][]map, int row, int col){
		for (int i = col; i < N - 1; i++) {
			if (map[row][i] == 0) {
				int tempCol = i + 1;
				while (tempCol < N - 1 && map[row][tempCol] == 0)
					tempCol++;
				map[row][i] = map[row][tempCol];
				map[row][tempCol] = 0;
			}
		}
		return map;
	}
	private static int[][] move0WhenDirEqual3(int [][]map, int row, int col){
		for (int i = col; i > 0; i--) {
			if (map[row][i] == 0) {
				int tempCol = i - 1;
				while (tempCol > 0 && map[row][tempCol] == 0)
					tempCol--;
				map[row][i] = map[row][tempCol];
				map[row][tempCol] = 0;
			}
		}
		return map;
		
	}
}
