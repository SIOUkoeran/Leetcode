import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String encrypt;
    static long  A =  'A', Z = 'Z', mod = 1000000, ZERO = '0';
    static long[] dp;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        encrypt = st.nextToken();
        dp = new long[encrypt.length() + 1];
    }
    static void solution() {
        if (encrypt.charAt(0) == '0')
        {
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < encrypt.length() + 1; i++){
            if (encrypt.charAt(i - 1) == '0'){
                if (encrypt.charAt(i - 2) != '1' && encrypt.charAt(i - 2) != '2'){
                    break ;
                }
                dp[i] = dp[i - 2] % mod;
            }
            else if (encrypt.charAt(i - 2) == ZERO){
                dp[i] = dp[i - 1] % mod;
            }
            else{
                    long num = Long.parseLong(encrypt.substring(i - 2, i));
                    dp[i] = (num >= 1 && num <= 26)
                            ? (dp[i - 2] + dp[i - 1]) % mod
                            : dp[i - 1] % mod;
                }
        }
        System.out.println(dp[encrypt.length()] % mod);
    }


}
