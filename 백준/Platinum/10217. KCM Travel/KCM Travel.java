import java.io.*;
import java.util.*;

public class Main{
	static int N, M, T, K;
	static LinkedList<Info>[] tickets;
	static int[][] dp;
	static class Info implements Comparable<Info>{
		private int dest;
		private int cost;
		private int dist;
		public Info(int dest, int cost, int dist) {
			this.dest = dest;
			this.cost = cost;
			this.dist = dist;
		}
		@Override
		public int compareTo(Info o) {
			if (this.dist < o.dist) return -1;
			if (this.dist == o.dist)
				return this.dist - o.dist;
			return 1;
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			tickets = new LinkedList[N + 1];
			for (int j = 1; j < N + 1; j++) {
				tickets[j] = new LinkedList<Info>();
			}
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				tickets[u].add(new Info(v, c, d));
			}
			solution();
			
		}
		System.out.println(sb);
	}
	static void solution() {
		PriorityQueue<Info> q = new PriorityQueue<Info>();
		dp = new int[N + 1][M + 1];
		
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
		}
		q.add(new Info(1, 0, 0));
		dp[1][0] = 0;
		while (!q.isEmpty()) {
			Info cur = q.poll();
			
			for (Info next : tickets[cur.dest]) {
				int dest = next.dest;
				int cost = next.cost + cur.cost;
				int dist = next.dist + cur.dist;
				
				if (cost > M) continue;
				if (dp[dest][cost] <= dist) continue;
				insertDp(dest, cost, dist);
				dp[dest][cost] = dist;
				q.add(new Info(dest, cost, dist));
			}
		}
		int answer = Integer.MAX_VALUE / 2;
		for (int i = 0; i < M + 1; i++) {
			answer = Math.min(answer, dp[N][i]);
		}
		if (answer == Integer.MAX_VALUE / 2)
			sb.append("Poor KCM").append('\n');
		else
			sb.append(answer).append('\n');
	}
	static void insertDp(int dest, int cost, int dist) {
		for (int i = cost; i < M + 1; i++) {
			dp[dest][i] = Math.min(dp[dest][i], dist);
		}
	}
}