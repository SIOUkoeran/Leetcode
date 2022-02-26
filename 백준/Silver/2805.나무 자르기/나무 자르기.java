import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees, 1, N + 1);
        solution();

    }
    static void solution(){
        long low = 0, high = 2000000000, ans = 0;
        while (low <= high){
            long mid = (low + high) / 2;
            if (determination((int)mid)){
                low = mid + 1;
                ans = mid;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
    static boolean determination(int H){
        long sum = 0;
        for (int i = 1; i < N + 1; i++) {
            if (trees[i] > H){
                sum += trees[i] - H;
            }
            if (sum >= M){
                return true;
            }
        }
        return false;
    }
}
