
import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static long answer = 0, sum = 0;;
	static int[] parents, childs;
	static ArrayList<Node> nodes;
	static boolean[] visited;
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int cost;
		
		public Node (int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o1) {
			// TODO Auto-generated method stub
			return o1.cost - this.cost;
		}
	}
 	public static void main(String[] args) throws Exception{
		input();
		solution();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];
		childs = new int[n + 1];
		Arrays.fill(parents, -1);
		Arrays.fill(childs, 1);
		nodes = new ArrayList<Node>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			sum += cost;
			if (from < to) nodes.add(new Node(from, to, cost));
			else nodes.add(new Node(from, to, cost));
			
		}
		Collections.sort(nodes);
	}

	private static void solution() {
		
		nodes.stream()
			.forEach(node -> {
				int[] parents = union(node.from, node.to);
				answer += sum * calculate(parents[0], parents[1]);
				answer %= 1_000_000_000;
				sum -= node.cost;
			}
		);
		System.out.println(answer);
	}
	
	private static int getParent(int target) {
		if (parents[target] == -1)
			return target;
		parents[target] = getParent(parents[target]);
		return parents[target];
	}
	
	private static int[] union(int x, int y) {
		
		int parentX = getParent(x);
		int parentY = getParent(y);
		
		if (parentX != parentY)
			parents[parentY] = parentX;
		return new int[]{parentX, parentY};
	}
	
	private static long calculate(int x, int y) {
		if (x == y)
			return 0;
		long cnt = (long) childs[x] * childs[y];
		childs[x] += childs[y];
		childs[y] = 0;
		return cnt;
	}
}
