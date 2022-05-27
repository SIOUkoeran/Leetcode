import java.io.*;
import java.util.*;

public class Main {
	
	static int M,N,A,B;
    static long C;
	static LinkedList<Cost>[] deg;
	static long[] distance;
	static class Cost implements Comparable<Cost>{
		public int next;
		public long cost;
		
		public Cost(int next, long cost) {
			this.next = next;
			this.cost = cost;
		}
		@Override
		public int compareTo(Cost o) {
			if (cost > o.cost) return 1;
			if (cost == o.cost) return 0;
			return -1;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Long.parseLong(st.nextToken());
		deg = new LinkedList[N + 1];
		distance = new long[N + 1];
		for (int i = 1; i < N + 1; i++) {
			deg[i] = new LinkedList<Cost>();
		}
		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			deg[a].add(new Cost(b,c));
			deg[b].add(new Cost(a,c));
		}
		solution();
	}
	static void solution() {
		long left = 1, right = 1000000001, ans = right;
		while (left <= right) {
			long mid = (left + right) / 2;
			if (dijkstra(mid)) {
				ans = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		if (ans == 1000000001) {
			ans = -1;
		}
		System.out.println(ans);
		return;
	}
	static boolean dijkstra(long mid) {
		for (int i = 1; i < N + 1; i++) {
			distance[i] = Long.MAX_VALUE;
		}
		distance[A] = 0;
		PriorityQueue<Cost> queue = new PriorityQueue<>();
		queue.add(new Cost(A, 0));
		while (!queue.isEmpty()) {
			Cost currentPoint = queue.poll();
			if (distance[currentPoint.next] != currentPoint.cost)
				continue;
			for (Cost next : deg[currentPoint.next]) {
				if (next.cost > mid) continue;
				if (next.cost + distance[currentPoint.next] < distance[next.next]) {
					distance[next.next] = distance[currentPoint.next] + next.cost;
					queue.add(new Cost(next.next, distance[next.next]));
				}
			}
		}
		return distance[B] <= C;
	}
	
}
