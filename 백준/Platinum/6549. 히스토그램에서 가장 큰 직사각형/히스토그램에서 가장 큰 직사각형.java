import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int[] heights;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st  = new StringTokenizer(br.readLine());;
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break ;
			heights = new int[N];
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			solution();		
			}
		System.out.println(sb);
    }
	static void solution() {
		long ans = 0;
		ans = divideAndConquer(0, N - 1);
		sb.append(ans).append('\n');
	}
	static long divideAndConquer(int low, int high) {
		if (low >= high) {
			return heights[low];
		}
		int mid = (low + high) / 2;
		long left = divideAndConquer(low, mid);
		long right = divideAndConquer(mid + 1, high);
		
		return Math.max(sumArea(low, high), Math.max(left, right));
	}
	
	static long sumArea(int low, int high) {
		int left = (low + high) / 2;
		int right = (low + high) / 2;
		long height = heights[(low + high) / 2];
		long area = height;
		while (low < left && right < high) {
			if (heights[left - 1] < heights[right + 1]) {
				right++;
				height = Math.min(height, heights[right]);
				area = Math.max(area, height * (right - left + 1));
			}else {
				left--;
				height = Math.min(height, heights[left]);
				area = Math.max(area, height * (right - left + 1));
			}
		}
		while (left > low) {
			left--;
			height = Math.min(height, heights[left]);
			area = Math.max(area, height * (right - left + 1));
		}
		while (right < high) {
			right++;
			height = Math.min(height, heights[right]);
			area = Math.max(area, height * (right - left + 1));
		}
		return area;
	}
}