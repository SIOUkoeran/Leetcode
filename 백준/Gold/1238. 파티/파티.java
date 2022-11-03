
import java.util.*;
import java.io.*;

public class Main {
	private static class Node{
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return " to : " + to + 
					" cost : " + cost;
		}
	}
	static int N,M,X, max = Integer.MIN_VALUE, maxNode, answer = Integer.MIN_VALUE;
	static LinkedList<Node>[] graph; 
	static boolean visited[];
	static int[] costs;
 	public static void main(String[] args) throws Exception{
		input();
		for (int i = 1; i < N + 1; i++) {
			if (i == X) continue;
			int go = solution(i, X);
			int back  = solution(X, i);
			answer = Math.max(answer, go + back);
		}
		System.out.println(answer);
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		costs = new int[N + 1];
		graph = new LinkedList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new LinkedList<Node>();
		}
		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to, cost));
		}
		
	}

	private static int solution(int start, int target) {
		Arrays.fill(visited, false);
		Arrays.fill(costs, Integer.MAX_VALUE);
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start, 0));
		visited[start] = true;
		costs[start] = 0;
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			for (Node next : graph[curNode.to]) {
				if (costs[next.to] > costs[curNode.to] + next.cost) {
					costs[next.to] = Math.min(costs[next.to], costs[curNode.to] + next.cost);
					q.add(next);
				}
			}
		}
		
		return costs[target];
	}
	
}
