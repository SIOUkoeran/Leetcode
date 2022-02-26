import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        solution();
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
    static boolean determination(int gap){
        int cnt = 1;
        int last = map[1];

        for (int i = 2; i < N + 1; i++) {
            if (map[i] - last >= gap){
                ++cnt;
                last = map[i];
            }

        }
        if (cnt >= C){
            return true;
        }
        return false;
    }
}
