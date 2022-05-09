	import java.util.*;
	import java.io.*;
	public class Main {
		static int N,M,K, answer;
		static char[][] map;
		static String target;
		static Map<String, Integer> answers = new HashMap<>();
		static int[] dx = {-1,1,0,0,-1,1,-1,1};
		static int[] dy = {0,0,-1,1,-1,1,1,-1};
		public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());
	        map = new char[N + 1][M + 1];
	        for (int i = 1; i < N + 1; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	String temp = st.nextToken();
	        	for (int j = 1; j < M + 1; j++) {
	        		map[i][j] = temp.charAt(j - 1);
	        	}
	        }
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < K; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	answer = 0;
	        	target = st.nextToken();
	        	if (answers.containsKey(target)) {
	        		sb.append(answers.get(target)).append('\n');
	        		continue;
	        	}
	        	solution();
	        	answers.put(target, answer);
	        	sb.append(answer).append('\n');
	        }
	        System.out.println(sb);
		}
		static void solution() {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					if (map[i][j] == target.charAt(0))
						bfs(i,j,String.valueOf(map[i][j]));
				}
			}
		}
		static void bfs(int x, int y, String comb) {
			if (comb.equals(target)) {
				++answer;
				return;
			}
			if (comb.length() >= target.length())
				return;
			for (int i = 0; i < 8; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if (nx < 1)
					nx = N;
				if (ny < 1)
					ny = M;
				if (nx > N)
					nx = 1;
				if (ny > M)
					ny = 1;
				if (checkComb(comb + map[nx][ny]))
					bfs(nx, ny, comb + map[nx][ny]);
			}
		}
		static boolean checkComb(String comb) {
			if (comb.length() > target.length()){
				return false;
			}
			if (comb.charAt(comb.length() - 1) != target.charAt(comb.length() - 1))
				return false;
			return true;
		}
	}
