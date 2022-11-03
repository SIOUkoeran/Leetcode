import java.util.*;
import java.io.*;

public class Main {
	private static class Node {
		int to;
		int cost;
		
		public Node (int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return "to = " + to 
					+ "cost = " + cost;
		}
	}
	static int N, V, max = Integer.MIN_VALUE, maxNode;
	static LinkedList<Node>[] graph;
	static int[] costs;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		input();
		solution(1);
		solution(maxNode);
		printAnswer();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		graph = new LinkedList[V + 1];
		costs = new int[V + 1];
		visited = new boolean[V + 1];
		
		for (int i = 0; i < V + 1; i++) {
			graph[i] = new LinkedList<Node>();
		}
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1)
					break ;
				int cost = Integer.parseInt(st.nextToken());
				graph[from].add(new Node(to, cost));
			}
		}
		
	}

	private static void solution(int start) {
		Queue<Node> q = new LinkedList<>();
		Arrays.fill(costs, 0);
		Arrays.fill(visited, false);
		
		q.add(new Node(start, 0));
		visited[start] = true;
		while (!q.isEmpty()) {
			Node curNode = q.poll();
			
			for (Node next : graph[curNode.to]) {
				if (visited[next.to]) continue;
				costs[next.to] = Math.max(costs[curNode.to] + next.cost, costs[next.to]);
				visited[next.to] = true;
				q.add(next);
			}
		}
		for (int i = 0; i < V + 1; i++) {
			
			if (costs[i] > max) {
				max = costs[i];
				maxNode = i;
			}
		}
	}
	
	private static void printAnswer() {
		System.out.println(max);
	}
	
}
