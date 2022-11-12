
import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	static int t, r, c, answer;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Point>[] tempQueue;
	static boolean[] key;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
 	public static void main(String[] args) throws Exception{
		input();
		printAnswer();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new char[r + 2][c + 2];
			for (int m = 0; m < r + 2; m++) {
				Arrays.fill(map[m], '.');
			}
			for (int j = 1; j < r + 1; j++) {
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				for (int k = 1; k < c + 1; k++) {
					map[j][k] = temp.charAt(k - 1);
				}
			}
			tempQueue = new LinkedList[28];
			for (int k = 0; k < 28; k++) {
				tempQueue[k] = new LinkedList<Point>();
				
			}
			key = new boolean[26];
			visited = new boolean[r + 2][c + 2];
			st = new StringTokenizer(br.readLine());
			Arrays.stream(st.nextToken().split(""))
				.filter(a -> a.charAt(0) != '0')
				.forEach(a -> key[(int) a.charAt(0) - 'a'] = true);
			solution();
			addAnswer();
		}
	}

	
	private static void solution() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx >= 0 && nx < r + 2 && ny >= 0 && ny < c + 2) {
					if (!visited[nx][ny]) {
						if (map[nx][ny] == '*') 
							continue;
						else if (map[nx][ny] == '.') {
							visited[nx][ny] = true;
							q.add(new Point(nx, ny));
						} else if (Character.isLowerCase(map[nx][ny])) {
							key[map[nx][ny] - 'a'] = true;
							visited[nx][ny] = true;
							q.add(new Point(nx, ny));
							if (tempQueue[map[nx][ny] - 'a'].size() > 0) {
								while (!tempQueue[map[nx][ny] - 'a'].isEmpty()) {
									Point tempPoint = tempQueue[map[nx][ny] - 'a'].poll();
									visited[tempPoint.x][tempPoint.y] = true;
									q.add(tempPoint);
								}
							}
						} else if (Character.isUpperCase(map[nx][ny])) {
							visited[nx][ny] = true;
							if (isHasKey(nx, ny)) 
								q.add(new Point(nx, ny));
							else {
								tempQueue[map[nx][ny] - 'A'].add(new Point(nx, ny));
								}							
						} else if (map[nx][ny] == '$') {
							visited[nx][ny] = true;
							++answer;
							q.add(new Point(nx, ny));
						}
					}
				}
			}
		}
	}
	
	private static boolean isHasKey(int x, int y) {
		char c = map[x][y];
		return key[c - 'A'];
	}
	
	private static void printAnswer() {
		System.out.println(sb.toString());
	}
	
	private static void addAnswer() {
		sb.append(answer).append("\n");
	}
	
}
