import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        solution();
    }
    static void solution(){
        long low = 1, high = (long) N * N, ans = 0;
        while (low <= high){
            long mid = (low + high) / 2;
            if (determination(mid)){
                high = mid -1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
    static boolean determination(long n){
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(N, n / i);
        }
        return sum >= K;
    }

}
