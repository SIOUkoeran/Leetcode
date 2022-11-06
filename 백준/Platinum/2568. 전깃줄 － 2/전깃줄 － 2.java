
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static LinkedList<Integer>[] tree;
	static int[][] trees;
	static int[] treesLIS;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list = new ArrayList<Integer>();
 	public static void main(String[] args) throws Exception{
		input();
		solution();
		print();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		trees = new int[N][2];
		
		treesLIS = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			trees[i][0] = from;
			trees[i][1] = to;
		}
		Arrays.sort(trees, Comparator.comparingInt(o -> o[0]));
		list.add(0);
	}

	private static void print() {
		System.out.println(sb);
	}
	
	private static void solution() {
		int result = binarySearch();
		sb.append(result).append("\n");
		tracing();
	}
	
	private static int binarySearch() {
		for (int i = 0; i < N; i++) {
			if (list.get(list.size() - 1) < trees[i][1]) {
				list.add(trees[i][1]);
				treesLIS[i] = list.size() - 1;
			}else {
				int low = 0, high = list.size() - 1;
				while (low < high) {
					int mid = (low + high) / 2;
					if (list.get(mid) >= trees[i][1]) {
						high = mid;
					}else {
						low = mid + 1;
					}
				}
				list.set(high, trees[i][1]);
				treesLIS[i] = high;
			}	
		}
		
		return N - (list.size() - 1);
	}
	
	private static void tracing() {
		int start = list.size() - 1;
		Stack<Integer> temp = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (treesLIS[i] == start) {
				start--;
			}else {
				temp.push(trees[i][0]);
			}
		}
		while (!temp.isEmpty()) {
			sb.append(temp.pop()).append("\n");
		}
	}
	
}
