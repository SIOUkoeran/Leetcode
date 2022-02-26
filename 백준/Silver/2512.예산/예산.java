import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,limit;
    static int[] countries;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        countries = new int[N + 1];
        long sum = 0;
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            countries[i] = Integer.parseInt(st.nextToken());
            sum += countries[i];
            max = Math.max(max, countries[i]);
        }
        st= new StringTokenizer(br.readLine());
        limit = Integer.parseInt(st.nextToken());
        if (sum <= limit){
            System.out.println(max);
        }else{
            solution();
        }

    }
    static void solution(){
        long low = 0, high = 1000000000, ans = 0;
        while (low <= high){
            long mid = (low + high) / 2;
            if (determination((int) mid)){
                low = mid + 1;
                ans = mid;
            }else{
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
    static boolean determination(int budget){
        long sum = 0;
        for (int i = 1; i < N + 1; i++) {
            if (countries[i] >= budget){
                sum += budget;
            }else{
                sum += countries[i];
            }
            if (sum > limit){
                return false;
            }
        }
        return true;
    }
}
