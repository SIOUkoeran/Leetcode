import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] lessons;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lessons = new int[N + 1];
        selected = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    static void solution(){
        int low = lessons[1], high = 1000000000, ans = 0;
        for (int i = 1; i < N + 1; i++) {
            low = Math.max(low, lessons[i]);
        }
        while (low <= high){
            int mid = (low + high) / 2;
            if (determination(mid)){
                high = mid - 1;
                ans = mid;

            }else{
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
    static boolean determination(int size){
        long sum = 0;
        int cnt = 1;

        for (int i = 1; i < N + 1; i++) {
            if (sum  + lessons[i]> size){
                sum = lessons[i];
                ++cnt;
            }else{
                sum += lessons[i];
            }
        }
        return cnt <= M;
    }
}
