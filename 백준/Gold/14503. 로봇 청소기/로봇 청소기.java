import java.io.*;
import java.util.*;

public class Main {
	static int N,M,ans;
	static int map[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static class Robot{
		int x;
		int y;
		int c;
		public Robot(int x, int y, int c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 1;
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(x, y, d);
		System.out.println(ans);
	}
	public static void dfs(int x, int y, int dir) {
        map[x][y] = 2; //청소 했다는 의미
        
        for(int i = 0; i < 4; i++) {
            dir -= 1; //왼쪽 방향으로 돌면서 탐색
            if(dir == -1) dir = 3;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(map[nx][ny] == 0) { //벽도 아니고 이미 청소한 곳도 아니라면 청소하러 이동한다
                    ans++;
                    dfs(nx, ny, dir);
                    //일반적인 dfs는 가다가 길이 막히면 다시 되돌아와서 해당 위치부터 계산하지만, 이 문제는 후진할 때만 이전 길을 되돌가 가며 확인할 수 있으므로 return을 해서 다시 되돌아 와도 더 이상 움직이면 안된다.
                    return;
                }
            }
        }
        
        //반목문을 빠져 나왔단는 것은 주변에 더 이상 청소할 공간이 없다는 의미이다.
        int d = (dir + 2) % 4; //반대 방향으로 후진하기 위함.
        int bx = x + dx[d];//후진
        int by = y + dy[d];//후진
        if(bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
            dfs(bx, by, dir); //후진할 때 방향을 유지해야 한다.
        }
    }
}
