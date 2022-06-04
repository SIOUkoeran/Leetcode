import java.awt.Point;

import java.io.*;

import java.util.Arrays;

import java.util.LinkedList;

import java.util.Queue;

import java.util.StringTokenizer;



public class Main {

	static char[][] map;

	static boolean[][] visited;

	static int R, C, N;

	static int[] command;

	static int dx[] = {-1,1,0,0};

	static int dy[] = {0,0,-1,1};

	public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());

        C = Integer.parseInt(st.nextToken());

        map = new char[R + 1][C + 1];

        for (int i = 1; i < R + 1; i++) {

        	st = new StringTokenizer(br.readLine());

        	String s = st.nextToken();

        	for (int j = 1; j < C + 1; j++){

        		map[i][j] = s.charAt(j - 1);

        	}

        }

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        command = new int[N];

        visited = new boolean[R + 1][C + 1];

        st = new StringTokenizer(br.readLine()); 

        for (int i = 0; i < N; i++) {

        	command[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 0; i < N; i++) {

        	solution(i);

        }

        for (int a = 1; a < R + 1; a++) {

        	for (int b = 1; b < C + 1; b++) {

        		System.out.print(map[a][b]);

        	}

        	if (a != R) {

        		System.out.println();

        	}

        	

        }

        

	}

	private static void moveMap(Queue<Point> q) {

		

		int maxRow = 0;

		int[][] rows = new int[C + 1][2];
		for (int i = 0; i < C +1; i++) {
			rows[i][1] = Integer.MAX_VALUE;
		}
		while (!q.isEmpty()) {

			Point cur = q.poll();

			rows[cur.y][0] = Math.max(rows[cur.y][0], cur.x);
			rows[cur.y][1] = Math.min(rows[cur.y][1], cur.x);
			maxRow = Math.max(maxRow, cur.x);

			visited[cur.x][cur.y] = true;

			for (int i = 0; i < 4; i++) {

				int nx = dx[i] + cur.x;

				int ny = dy[i] + cur.y;

				if (nx > 0 && ny > 0 && nx < R + 1 && ny < C + 1) {
					if (!visited[nx][ny] && map[nx][ny] == 'x') {
						q.add(new Point(nx, ny));
						
						visited[nx][ny] = true;
					}

				}

			}

		}
        
		if (maxRow != R) {
			

			for (int re = 0; re < R - maxRow + 1; re++) {

				boolean flag = true;

				for (int i = 1; i < C + 1; i++) {

					if (rows[i][0] != 0) {

						if (rows[i][0] + 1 > R) {

							flag = false;

							break;

						}	

						if (map[rows[i][0] + 1][i] == 'x')

							flag = false;

					}

				}

				if (!flag)

					break;

				if (flag) {

					for (int i = 1; i < C + 1; i++) {

						int r = rows[i][0];

						if (r + 1 < R + 1 && r != 0) {

							for (int j = r + 1; j > rows[i][1]; j--) {
								

								map[j][i] = map[j - 1][i];

								map[j - 1][i] = '.';

							}

							rows[i][0] += 1;

						}

					}

				}

			}

		}

	}

	

	private static Queue<Point> checkMap(int row, int col){

		for (int i = 0; i < R + 1; i++) {
			Arrays.fill(visited[i], false);
		}

		Queue<Point> q = new LinkedList<Point>();

		for (int i = 0; i < 4; i++) {

			int nx = dx[i] + row;

			int ny = dy[i] + col;

			if (nx > 0 && ny > 0 && nx < R + 1 && ny < C + 1) {

				if (!visited[nx][ny] && map[nx][ny] == 'x') {

					q.add(new Point(nx, ny));

					visited[nx][ny] = true;

					moveMap(q);

				}

			}

		}

		return q;

	}

	private static void solution(int idx) {

		int height = command[idx];

		if ((idx + 1) % 2 == 1) {

			for (int i = 1; i < C + 1; i++) {

				if (map[R - height + 1][i] == 'x') {

					map[R - height + 1][i] = '.';

					checkMap(R - height + 1, i);

					return;

				}

			}



		}else {

			for (int i = C; i > 0; i--) {

				if (map[R - height + 1][i] == 'x') {

					map[R - height + 1][i] = '.';

					checkMap(R - height + 1, i);

					return;

				}

			}

		}

	}

}