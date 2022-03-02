import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String alphabet = st.nextToken();
        cnt = new int[26];
        solution(alphabet);
    }
    static void solution(String alphabet){
        int ans = 0;
        int len = alphabet.length();
        int low = 0;
        for (int high = 0; high < len; high++){
            add(alphabet.charAt(high));


            while (true){
                int kind = 0;
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] != 0){
                        kind++;
                    }
                }
                if (kind <= N){
                    break;
                }
                erase(alphabet.charAt(low));
                low++;
            }
            ans = Math.max(ans, high - low + 1);
        }
        System.out.println(ans);
    }
    static void add(char x){
        ++cnt[x - 'a'];
    }
    static void erase(char x){
        --cnt[x - 'a'];
    }
}
