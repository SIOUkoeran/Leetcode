import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K,N;
    static int[] cables;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cables = new int[K + 1];

        for (int i = 1; i < K + 1; i++) {
            st = new StringTokenizer(br.readLine());
            cables[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    static void solution(){
        long low = 0, high = Integer.MAX_VALUE, ans = 0;
        while (low <= high){
            long mid = (low + high) / 2;
            if (determination((int)mid)){
                low = mid + 1;
                ans = mid;
            }else{
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
    static boolean determination(int length){
        int sum = 0;
        for (int i = 1; i < K + 1; i++) {
            int temp = cables[i];
            while (temp >= length){
                temp = temp - length;
                ++sum;
            }
            if (sum >= N)
                return true;
        }
        return false;
    }
}
