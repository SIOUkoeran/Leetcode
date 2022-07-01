import java.io.*;
import java.util.*;

public class Main{
	static char[] s1, s2;
	static int[][] dp; 
	static int minCost = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String tempS1 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String tempS2 = st.nextToken();
		s1 = new char[tempS1.length() + 1];
		for (int i = 1; i < tempS1.length() + 1; i++) {
			s1[i] = tempS1.charAt(i - 1);
		}
		s2 = new char[tempS2.length() + 1];
		for (int i = 1; i < tempS2.length() + 1; i++) {
			s2[i] = tempS2.charAt(i - 1);
		}
		dp = new int[s1.length + 1][s2.length + 1];
		solution();
    }
    static void solution() {
    	for (int i = 1; i < s1.length; i++) {
    		for (int j = 1; j < s2.length; j++) {
    			if (s1[i] == s2[j]) {
    				dp[i][j] = dp[i - 1][j - 1] + 1;
    			} else {
    				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    			}
    		}
    	}
    	print();
    	
    }
    static void print() {
    	System.out.println(dp[s1.length - 1][s2.length - 1]);
    	
    	int i = s1.length - 1;
    	int j = s2.length - 1;
    	while (dp[i][j] != 0) {
    		if (s1[i] == s2[j]) {
    			sb.append(s1[i]);
    			--i;
    			--j;
    		}else if (dp[i - 1][j] > dp[i][j - 1]) {
    			--i;
    		}else if (dp[i - 1][j] <= dp[i][j - 1]) {
    			--j;
    		}
    	}
    	System.out.println(sb.reverse());
    }
}