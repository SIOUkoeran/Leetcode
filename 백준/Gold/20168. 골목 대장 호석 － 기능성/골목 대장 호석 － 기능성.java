import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static class Cost{
		long cost;
		int dest;
		public Cost(long cost, int dest){
			this.cost = cost;
			this.dest = dest;
		}
	}
	static LinkedList<Cost>[] deg;
	
	static int N,M,A,B,C;
	static long min = Long.MIN_VALUE;
	static long max = Long.MIN_VALUE;
	static long ans = Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		deg = new LinkedList[N + 1];
		visited = new boolean[N  + 1];
		for (int i = 1; i < N + 1; i++) {
			deg[i] = new LinkedList<Cost>();
		}
		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int arrival = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			deg[arrival].add(new Cost(cost, destination));
			deg[destination].add(new Cost(cost, arrival));
		}
		solution();
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
	static void solution() {
		dfs(A,-1,C);
	}
	static void dfs(int cur, long cnt, long total) {
		if (cur == B) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (total <= 0)
			return;
		for (Cost c : deg[cur]) {
				min = Math.max(c.cost, min);
				if (visited[c.dest] || total < c.cost)
					continue;
				visited[c.dest] = true;
				dfs(c.dest, Math.max(c.cost, cnt), total - c.cost);
				visited[c.dest] = false;
		}
	}
}