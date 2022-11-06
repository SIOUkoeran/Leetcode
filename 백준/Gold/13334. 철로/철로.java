
import java.util.*;
import java.io.*;

public class Main {
	static int n, length;
	static int[][] info;
	
 	public static void main(String[] args) throws Exception{
		input();
		solution();
		
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		info = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			info[i][0] = from < to 
					? from
					: to;
			info[i][1] = from < to
					? to
					: from;
		}
		st = new StringTokenizer(br.readLine());
		length = Integer.parseInt(st.nextToken());
		
		Arrays.sort(info, Comparator.comparingInt(o -> o[1]));
	}

	private static void solution() {
		PriorityQueue<int[]> pq
			= new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));		
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			int[] cur = info[i];
			pq.offer(info[i]);
			while (!pq.isEmpty() && !(pq.peek()[0] >= cur[1] - length && pq.peek()[1] <= cur[1])) {
				pq.poll();
			}
			answer = Math.max(answer, pq.size());
		}
		
		System.out.println(answer);
	}
	
}
