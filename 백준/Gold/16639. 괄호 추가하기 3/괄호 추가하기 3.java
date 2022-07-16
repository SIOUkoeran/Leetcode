import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static char[] inputs;
	static int[][] minDp, maxDp;
	public static void main(String[] args) throws IOException{
        input();
		solution();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(minDp[i]));
//		}
//		System.out.println("MAx");
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(maxDp[i]));
//		}
		System.out.println(maxDp[0][N - 1]);
	}
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String temp = st.nextToken();
		inputs = new char[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = temp.charAt(i);
		}
	}
	static void solution() {
		minDp = new int[N][N];
		maxDp = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(minDp[i], Integer.MAX_VALUE);
			Arrays.fill(maxDp[i], Integer.MIN_VALUE);
		}
		for (int i = 0; i < N; i++) {
			if (isOdd(i)) {
				minDp[i][i] = (int) inputs[i] - '0';
				maxDp[i][i] = (int) inputs[i] - '0';
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isOdd(i) && isOdd(j) && ((i - j == 2) || (j - i) == 2) ) {
					insertDp(i, j);
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(maxDp[i]));
//		}
		int temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0;
		for (int i = 4; i < N; i+= 2) {
			for (int j = 0; j < N - i; j+= 2) {
				for (int k = 2;  k <= i; k+= 2) {
					temp1 = calculate(minDp[j][j + k - 2], minDp[j + k][i + j], inputs[(j + k - 1)]);
					temp2 =	calculate(minDp[j][j + k - 2], maxDp[j + k][i + j], inputs[(j + k - 1)]);
					temp3 = calculate(maxDp[j][j + k - 2], minDp[j + k][i + j], inputs[(j + k - 1)]);
					temp4 = calculate(maxDp[j][j + k - 2], maxDp[j + k][i + j], inputs[(j + k - 1)]);
//						System.out.print(inputs[(j + k - 1)] + " idx " + (j + k - 1));
//						System.out.print(temp1 + " " );
//						System.out.print(temp2 + " ");
//						System.out.print(temp3 + " ");
//						System.out.print(temp4 + " ");
//						System.out.println("");
					minDp[j][j + i] = Math.min(minDp[j][j + i], Math.min(Math.min(temp1, temp2), Math.min(temp3, temp4)));
					maxDp[j][j + i] = Math.max(maxDp[j][j + i], Math.max(Math.max(temp1, temp2), Math.max(temp3, temp4)));
				}
			}
		}
		
	}
	
	static int calculate(int x, int y, char op) {
		if (op == '-') {
			return x - y;
		}else if (op == '+') {
			return x + y;
		}else {
			return x * y;
		}
	}
	
	static boolean isOdd(int i) {
		return (i + 1) % 2 == 1;
	}
	
	static int findMin(int t1, int t2, int t3, int t4, int t5, int t6, int t7, int t8) {
		return  Math.min(Math.min(Math.min(t1, t2), Math.min(t3, t4))
				, Math.min(Math.min(t5, t6), Math.min(t7, t8)));
	}
	
	static int findMax(int t1, int t2, int t3, int t4, int t5, int t6, int t7, int t8) {
		return  Math.max(Math.max(Math.max(t1, t2), Math.max(t3, t4))
				, Math.max(Math.max(t5, t6), Math.max(t7, t8)));
	}
	

	static void insertDp(int from, int to) {
//		System.out.println("from" + from + " " + "to " + to + " " + Math.abs(to - from));
		if (inputs[Math.max(to, from) - 1] == '+') {
			minDp[from][to] = Integer.valueOf(inputs[from] - '0') + Integer.valueOf(inputs[to] - '0');
			maxDp[from][to] = Integer.valueOf(inputs[from]- '0') + Integer.valueOf(inputs[to] - '0');
		}else if (inputs[Math.max(to, from) - 1] == '-'){
			minDp[from][to] = Integer.valueOf(inputs[from] - '0') - Integer.valueOf(inputs[to] - '0');
			maxDp[from][to] = Integer.valueOf(inputs[from] - '0') - Integer.valueOf(inputs[to] - '0');
		}else if (inputs[Math.max(to, from) - 1] == '*'){
			minDp[from][to] = Integer.valueOf(inputs[from] - '0') * Integer.valueOf(inputs[to] - '0');
			maxDp[from][to] = Integer.valueOf(inputs[from] - '0') * Integer.valueOf(inputs[to] - '0');
//			System.out.println(maxDp[from][to]);
		}
	}
}