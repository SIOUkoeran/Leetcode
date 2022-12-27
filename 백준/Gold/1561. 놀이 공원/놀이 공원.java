
import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	static int n,m, answer = 0;
	static int[] rides;
 	public static void main(String[] args) throws Exception{
		input();
		solution();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		rides = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			rides[i] = Integer.parseInt(st.nextToken());
		}
	}

	
	private static void solution() {
		if (n <= m) {
			System.out.println(n);
			return;
		}
			
		long time = binarySearch() - 1;
		long people = m;
		for (int i = 0; i < m; i++) {
			people += time / rides[i];
		}
		++time;
		for (int i = 0; i < m; i++) {
			people = time % rides[i] == 0 
					? people + 1
					: people;
			if (people == n) {
				System.out.println(i + 1);
				return;
			}
				
		}
	}
	
	/**
	 *시간 이분탐색 
	 * @return
	 */
	private static long binarySearch() {
		long low = 0;
		long result = 0;
		long high = 2_000_000_000 * 30L;
		while (low <= high) {
			long mid = (low + high) / 2;
			long people = calculate(mid);
			if (people >= n) {
				high = mid - 1;
				result = mid;
			}else 
				low = mid + 1;
			
		}
		return result;
	}
	
	/**
	 * 입력받은 시간에 놀이기구 탑승 가능한 인원수 계산 함 
	 * @param time
	 * @return 탑승 가능한 인원수 반환
	 */
	private static long calculate(long time) {
		long people = m;
		for (int i = 0; i < m; i++) {
			people += time / rides[i]; 
		}
		return people;
	}
	
}
