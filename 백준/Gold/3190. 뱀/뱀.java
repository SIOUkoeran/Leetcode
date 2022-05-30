import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static class Command{
		int time;
		char dir;
		
		public Command(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
	}
	static int dx[] = {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	static int N,K,L,time;
	static int[][] map;
	static LinkedList<Point> visited = new LinkedList<Point>();
	static Command[] command;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		time = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = -1;
		}
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		command = new Command[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			command[i] = new Command(x,c);	
		}
		solution();
		System.out.println(time);
	}
	private static boolean checkPosition(int positionX, int positionY)
	{
		if (positionX < 1 || positionY < 1 || positionX > N || positionY > N)	
			return false;
		return true;
	}
	static void solution() {
		int dir = 0;
		int positionX = 1, positionY = 1;
		map[positionX][positionY] = 1;
		visited.add(new Point(positionX, positionY));
		for (int i = 0; i < L; i++) {
			Command current = command[i];
			while (time < current.time) {
				++time;
				int nx = positionX + dx[dir];
				int ny = positionY + dy[dir];
				if (!checkPosition(nx,ny))	
					return;
				else if (checkPosition(nx, ny) && map[nx][ny] == -1) {
					map[nx][ny] = 1;
					visited.add(new Point(nx, ny));
				}
				else if (checkPosition(nx, ny) && map[nx][ny] == 1) {
					return;
				}
				else if (checkPosition(nx, ny) && map[nx][ny] == 0) {
					map[nx][ny] = 1;
					Point visit = visited.poll();
					map[visit.x][visit.y] = 0;
					visited.add(new Point(nx, ny));
				}
				positionX = nx;
				positionY = ny;
				
			}
			dir = changeDirection(current.dir, dir);
		}
		while (true) {
			int nx = positionX + dx[dir];
			int ny = positionY + dy[dir];
			++time;
			
			if (!checkPosition(nx,ny))	
				return;
			else if (map[nx][ny] == -1) {
				map[nx][ny] = 1;
				visited.add(new Point(nx, ny));
			}
			else if (map[nx][ny] == 1) {
				return;
			}
			else if (map[nx][ny] == 0) {
				map[nx][ny] = 1;
				Point visit = visited.poll();
				map[visit.x][visit.y] = 0;
				visited.add(new Point(nx, ny));
			}
			positionX = nx;
			positionY = ny;
		}
	}
	static int changeDirection(char c, int dir) {
		
		if (c == 'D') {
			return ((dir + 3) % 4);
		}else {
			return ((dir + 5) % 4);
		}
	}
	
}
