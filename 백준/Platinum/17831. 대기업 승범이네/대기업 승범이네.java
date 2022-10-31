
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] sellerMentor;
	static int[] sellerAbility;
	static LinkedList<Integer>[] mentorTree;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		input();
		solution(1,0);
		printAnswer();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sellerMentor = new int[N + 1];
		sellerAbility = new int[N + 1];
		dp = new int[N + 1][2];
		mentorTree = new LinkedList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			mentorTree[i] = new LinkedList<Integer>();
		}
		for (int i = 2; i < N + 1; i++) {
			int mentor = Integer.parseInt(st.nextToken());
			sellerMentor[i] = mentor;
			mentorTree[mentor].add(i);
 		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			sellerAbility[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}
	}
	
	private static int solution(int cur, int isTeam) {
		
		if (dp[cur][isTeam] != -1)
			return dp[cur][isTeam];
		
		dp[cur][isTeam] = 0;
		
		for (int mentee : mentorTree[cur]) {
			dp[cur][isTeam] += solution(mentee, 0);
		}
		if (checkThisNodeSolo(isTeam)) {
			int temp = dp[cur][isTeam];
			for (int mentee : mentorTree[cur]) {
				dp[cur][isTeam] =
						Math.max(dp[cur][isTeam], 
								temp - solution(mentee, 0) + solution(mentee, 1) 
										+ sellerAbility[mentee] * sellerAbility[cur]); 
			}
		}
		return dp[cur][isTeam];
	}
	
	private static boolean checkThisNodeSolo(int isMentor) {
		return isMentor == 0;
	}
	
	private static void printAnswer() { 
		System.out.println(dp[1][0]);
	}
	
	
}
