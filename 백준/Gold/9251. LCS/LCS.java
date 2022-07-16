import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String keyword1, keyword2;
    static int[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        input();
        solution();
//        for (int i = 0; i < keyword1.length(); i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }
    public static void solution(){
        for (int i = 1; i < keyword1.length() + 1; i++) {
            for (int j = 1; j < keyword2.length() + 1; j++) {
                if (keyword1.charAt(i - 1) == keyword2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[keyword1.length()][keyword2.length()]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        keyword1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        keyword2 = st.nextToken();
        dp = new int[keyword1.length() + 1][keyword2.length() + 1];
    }
}

