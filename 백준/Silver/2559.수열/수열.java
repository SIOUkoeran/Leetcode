import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] temperatures;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        temperatures = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    static void solution(){
        int high = 0, ans = -100 * N, sum = 0;
        for (int low = 1; low <= N + 1 - K; low++) {
            sum -= temperatures[low - 1];
            while (high - low < K){
                sum += temperatures[high];
                high++;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
