import java.awt.Point;

import java.io.*;
import java.util.*;



public class Main {
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static LinkedList<Point> willMeltIndex = new LinkedList<>();
	static Point swan1, swan2;
	static Queue<Point> q = new LinkedList<Point>();
	static int[] dx = {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R + 1][C + 1];
		visited = new boolean[R + 1][C + 1];
		for (int i = 1; i < R + 1; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for (int j = 1; j < C + 1; j++) {
				map[i][j] = temp.charAt(j - 1);
				if (temp.charAt(j - 1) == 'L') {
					if (swan1 == null) {
						swan1 = new Point(i,j);
					}else {
						swan2 = new Point(i, j);
					}
				}
				if (temp.charAt(j - 1) != 'X') {
					willMeltIndex.add(new Point(i,j));
				}
			}
		}
		solution();
	}
	static void solution() {
		int days = 0;
		Queue<Point>nextQ = new LinkedList<Point>();
		q.add(swan1);
		visited[swan1.x][swan1.y] = true;
		while (!isSwanCanReach(nextQ)) {
			nextQ = new LinkedList<>();
			meltLakeIce();
			days++;
		}
		System.out.println(days);
	}
	static void meltLakeIce() {
		
 		int cnt = willMeltIndex.size();
 		for (int i = 0; i < cnt; i++) {
 			Point meltPosition = willMeltIndex.poll();
 			for (int d = 0; d < 4; d++) {
				int nx = meltPosition.x + dx[d];
				int ny = meltPosition.y + dy[d];
				if (nx > 0 && ny > 0 && nx < R + 1 && ny < C + 1) {
					if (map[nx][ny] == 'X') {
						map[nx][ny] = '.';
						willMeltIndex.addLast(new Point(nx, ny));
					}
				}
 			}
 		}
	
	}
	static boolean isSwanCanReach(Queue<Point> nextQ) {
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.x == swan2.x && cur.y == swan2.y) {
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx > 0 && ny > 0 && nx < R + 1 && ny < C + 1) {
					if (!visited[nx][ny] && map[nx][ny] != 'X') {
						q.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
					else if (!visited[nx][ny] && map[nx][ny] == 'X') {
						nextQ.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
		q = nextQ;
		return false;
	}
}