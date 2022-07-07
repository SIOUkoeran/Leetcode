import java.io.*;
import java.util.*;

public class Main{
	static int T;
	static int h, w;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	static Prisoner prisoner1, prisoner2;
	static class Prisoner{
		private int x;
		private int y;
		private int door;
		public Prisoner(int x, int y, int door) {
			this.x = x;
			this.y = y;
			this.door = door;
		}
		@Override
		public String toString() {
			return "x " + x 
					+ "y " + y
					+ "door " + door;
		}
	}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h + 2][w + 2];
			for (int i = 0; i < h + 2; i++) {
				Arrays.fill(map[i], '.');
			}
			prisoner1 = null;
			prisoner2 = null;
			for (int i = 1; i < h + 1; i++) {
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				for (int j = 1; j < w + 1; j++) {
					map[i][j] = temp.charAt(j - 1);
					if (map[i][j] == '$') {
						if (prisoner1 == null)
							prisoner1 = new Prisoner(i,j,0);
						else
							prisoner2 = new Prisoner(i,j,0);
					}
				}
			}
			solution();
		}
		System.out.println(sb);
    }
    static void solution(){
    	Prisoner notPrisoner = new Prisoner(0,0,0);
    	int[][] prisoner1Visited = bfs(prisoner1.x, prisoner1.y);
    	int[][] prisoner2Visited = bfs(prisoner2.x, prisoner2.y);
    	int[][] notPrisonerVisited = bfs(notPrisoner.x, notPrisoner.y);
    	int ans = Integer.MAX_VALUE;
    	int sum = 0;
    	for (int i = 0; i < h + 2; i++) {
    		for (int j = 0; j < w + 2; j++) {
    			if (map[i][j] == '*')
    				continue;
    			if (prisoner1Visited[i][j] != -1 && prisoner2Visited[i][j] != -1 && notPrisonerVisited[i][j] != -1)
    				sum = prisoner1Visited[i][j] + prisoner2Visited[i][j] + notPrisonerVisited[i][j];
    			if (map[i][j] == '#')
    				sum -= 2;
    			ans = Math.min(ans, sum);
    		}
    	}
    	sb.append(ans).append('\n');
    }
    static int[][] bfs(int x, int y) {
    	Deque<Prisoner> q = new LinkedList<>();
    	q.add(new Prisoner(x,y,0));
    	int[][] visited = createVisitedArray();
    	visited[x][y] = 0;
    	while (!q.isEmpty()) {
    		Prisoner cur = q.poll();
    		for (int i = 0; i < 4; i++) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			int door = cur.door;
    			if (nx >= 0 && ny >= 0 && nx < h + 2 && ny < w + 2) {
    				if (map[nx][ny] != '*') {
	    				if (map[nx][ny] == '#') {
	    					++door;;
	    				}
	    				if (visited[nx][ny] == -1 || visited[nx][ny] > door) {
	    					visited[nx][ny] = door;
	    					if (map[nx][ny] == '#')
	    						q.addFirst(new Prisoner(nx, ny, door));
	    					else 
	    						q.add(new Prisoner(nx, ny, door));
	    					
    					}
    				}
    			}
    		}
    	}
    	return visited;
    }
    static int[][] createVisitedArray() {
    	int[][] intArray = new int[h + 2][w + 2];
    	for (int i = 0; i < h + 2; i++) {
    		Arrays.fill(intArray[i], -1);
    	}
    	return intArray;
    }
}