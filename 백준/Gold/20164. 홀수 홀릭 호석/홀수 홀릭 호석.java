import java.util.*;
import java.io.*;
public class Main {
	static String str;
	static int cnt1 = 1;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = String.valueOf(st.nextToken());
        solution();
        System.out.print(min + " ");
        System.out.print(max);
	}
	static void solution() {
		divide(0, str, countOdd(str));
	}
	
	static void divide(int start, String s, int cnt) {
		if (s.length() >= 3) {
			//ToDo 구간 3개로 나누기
			divide3(s, cnt);
		}
		if (s.length() == 2) {
			divide2(s, cnt);
		}
		else if (s.length() == 1) {
			max = Math.max(max, cnt);
			min = Math.min(min, cnt);
			return;
		}
	}
	
	static void divide3(String s, int cnt) {
		for (int i = 0; i < s.length() - 2; i++) {
			for (int j = i + 1; j < s.length() - 1; j++) {
				String s1 = s.substring(0, i + 1);
				String s2 = s.substring(i + 1, j + 1);
				String s3 = s.substring(j + 1, s.length());
				int result = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
				divide(0, String.valueOf(result), cnt + countOdd(String.valueOf(result)));
			}
		}
	}
	static void divide2(String s, int cnt) {
		int result = (int) s.charAt(0) - '0' + (int) s.charAt(1) - '0';
		divide(0, String.valueOf(result), cnt + countOdd(String.valueOf(result)));
	}
	
	static int countOdd(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (((int) c - '0') % 2 == 1) {
				cnt++;
			}
		}
		return cnt;
	}
	
}
