import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] log;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        log = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st= new StringTokenizer(br.readLine());
            log[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    static void solution(){
        long low =log[1], high = 1000000000, ans = 0;
        for (int i = 1; i < N + 1; i++) {
            low = Math.max(low, log[i]);
        }
        while (low <= high){
            long mid = (low + high) / 2;
            if (determination((int) mid)){
                high = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
    static boolean determination(int cost){
        int sum = 0, cnt = 1;
        for (int i = 1; i < N + 1; i++) {
            if (log[i] + sum > cost){
                sum = log[i];
                ++cnt;
            }else{
                sum += log[i];
            }
        }
        return cnt <= M;
    }
}
