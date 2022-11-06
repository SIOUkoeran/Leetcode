
import java.util.*;
import java.io.*;

public class Main {
	static int N,M,K;
	static int[] cards, parents;
	static int[] order;
	static StringBuilder stringBuilder = new StringBuilder();
 	public static void main(String[] args) throws Exception{
		input();
		solution();
		print();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cards = new int[M];
		order = new int[K];
		parents = new int[M];
		Arrays.fill(parents, -1);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
	}

	private static void solution() {
		for (int i = 0; i < K; i++) {
			int idx = search(order[i]);
			int idxParent = findParent(idx);
			stringBuilder.append(cards[idxParent]).append("\n");
			union(idxParent, idxParent + 1);
		}
	}
	
	private static void print() {
		System.out.println(stringBuilder.toString());
	}
	
	private static int search(int target) {
		int low = 0;
		int high = M;
		
		while (low < high) {
			int mid = (low + high) / 2;
			
			if (cards[mid] > target) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		return high;
	}
	
	private static void union(int x, int y) {
		if (y >= M)
			return ;
		
		int parentX = findParent(x);
		int parentY = findParent(y);
		
		parents[parentX] = parentY;
	}
	
	private static int findParent(int idx) {
		if (parents[idx] == -1)
			return idx;
		if (idx == parents[idx])
			return parents[idx];
		
		int temp = findParent(parents[idx]);
		parents[idx] = temp;
		return temp;
	}
}
