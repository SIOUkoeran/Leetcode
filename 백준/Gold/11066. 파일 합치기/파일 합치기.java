import java.io.*;

import java.util.Arrays;

import java.util.LinkedList;

import java.util.Queue;

import java.util.StringTokenizer;



public class Main {

	static int T,K;
	static int[] files, sum;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(br.readLine());
        	K = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	files = new int[K + 1];
        	sum = new int[K + 1];
        	dp = new int[K + 1][K + 1];
        	for (int j = 1; j < K + 1; j++) {
        		files[j] = Integer.parseInt(st.nextToken());
        	}
        	solution();
        }
	}
	
	private static void solution() {
		sum[1] = files[1];
		for (int i = 1; i < K; i++) {
			dp[i][i + 1] = files[i] + files[i + 1];
			sum[i + 1] = sum[i] + files[i + 1];
		}
		
		for (int j = 2; j < dp.length; j++) {
            for (int i = 1; i + j < dp.length; i++) {
                for (int k = i; k < i + j; k++) {
                	int temp =  dp[i][k] + dp[k + 1][i + j] + minSum(sum, i, i + j);
                    if (dp[i][i + j] == 0) {
                        dp[i][i + j] = temp;
                    } else {
                        dp[i][i + j] = Math.min(dp[i][i + j], temp);
                    }
                }
            }
        }
		
		System.out.println(dp[1][K]);
	}
	
	private static int minSum(int[] sum, int start, int end) {
		if (start == 1) {
			return sum[end];
		}
		return sum[end] - sum[start - 1];
	}

}