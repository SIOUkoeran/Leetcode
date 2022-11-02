import java.util.*;
import java.io.*;

public class Main {
	static int N, T;
	static boolean[] visited;
	static String[] commandHistory;
	public static void main(String[] args) throws Exception{
		input();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			commandHistory = new String[10001];
			Arrays.fill(commandHistory, "");
			visited = new boolean[10001];
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			solution(from, target);
		}
		
	}
	
	private static void solution(int from, int target) {
		if (from == target)
			return ;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(from);
		visited[from] = true;
		while (!q.isEmpty() && !visited[target]) {
			int num = q.poll();
			
			int s = commandS(num);
			if (!visited[s]) {
				q.add(s);
				visited[s] = true;
				commandHistory[s] = commandHistory[num] + "S";
				if (checkIsSame(s, target)) {
					System.out.println(commandHistory[target]);
					break;
				}
			}
			
			int l = commandL(num);
			if (!visited[l]) {
				q.add(l);
				visited[l] = true;
				commandHistory[l] = commandHistory[num] + "L";
				if (checkIsSame(l, target)) {
					System.out.println(commandHistory[target]);
					break;
				}
			}
			
			int r = commandR(num);
			if (!visited[r]) {
				q.add(r);
				visited[r] = true;
				commandHistory[r] = commandHistory[num] + "R";
				if (checkIsSame(r, target)) {
					System.out.println(commandHistory[target]);
					break;
				}
			}
			
			int d = commandD(num);
			if (!visited[d]) {
				q.add(d);
				visited[d] = true;
				commandHistory[d] = commandHistory[num] + "D";
				if (checkIsSame(d, target)) {
					System.out.println(commandHistory[target]);
					break ;
				}
					
			}
		}
	}
	
	private static boolean checkIsSame(int a, int b) {
		return a == b;
	}
	
	private static int commandS(int from) {
		if (from == 0)
			return 9999;
		return from - 1;
	}
	
	private static int commandL(int from) {
		return (from % 1000 * 10 + from / 1000);
	}
	
	private static int commandD(int from) {
		return (from * 2) % 10000;
	}
	
	private static int commandR(int from) {
		return (from % 10 * 1000 + from / 10);
	}
}
