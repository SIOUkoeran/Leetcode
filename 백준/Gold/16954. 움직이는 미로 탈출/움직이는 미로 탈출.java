import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static boolean flag = false;
    static char[][] map;
    static int startX = 7, startY = 0;
    static int[] dx = {-1,1,0,0,-1,-1,1,1,0};
    static int[] dy = {0,0,-1,1,-1,1,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new char[8][8];
		for (int i = 0; i < 8; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for (int j = 0; j < 8; j++) {
				map[i][j] = temp.charAt(j); 
			}
		}
		solution();
    }
    static void solution() {
    	bfs();
    	if (flag) System.out.println(1);
    	else System.out.println(0);
    }
    static void bfs() {
    	Queue<Point> q = new LinkedList<Point>();
    	q.add(new Point(startX, startY));
    	while(!q.isEmpty()) {
    		int cnt = q.size();
    		for (int t = 0; t < cnt; t++) {
    			Point cur = q.poll();
        		if (flag == true)
        			return;
        		if (cur.x == 0 && cur.y == 7) flag = true;
        		
        		if (map[cur.x][cur.y] == '#')
        			continue;
        		for (int i = 0; i < 9; i++) {
            		int nx = dx[i] + cur.x;
            		int ny = dy[i] + cur.y;
            		if (nx >= 0 && nx < 8 && ny>= 0 && ny < 8) {
            			if (map[nx][ny] == '.') {
            				q.offer(new Point(nx, ny));
            			}
            		}
            	}
    		}
    		map = move(map);
    	}
    }
    static char[][] move(char[][] map){
    	char[][] returnMap = new char[8][8];
    	char[] tempRow = new char[8];
    	tempRow = map[0];
    	for (int i = 0; i < 8; i++) {
    		returnMap[0][i] = '.';
    	}
    	for (int i = 1; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			returnMap[i][j] = tempRow[j];
    		}
    		tempRow = map[i];
    	}
    	return returnMap;
    }
    static boolean isValid(int characterX, int characterY, int wallX, int wallY) {
    	if (characterX == wallX && characterY == wallY) {
    		return false;
    	}
    	return true;
    }
}