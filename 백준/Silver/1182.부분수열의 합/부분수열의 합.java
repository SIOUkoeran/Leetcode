import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int cnt = 0;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            nums[i] =  Integer.parseInt(st.nextToken());
        }
        if (S == 0){
            cnt--;
        }
        rec_fun(1,0);
        System.out.println(cnt);
    }
    static void rec_fun(int k,int value){
        if (k == N + 1){
            if (value == S){
                cnt++;
            }
        }else{
            rec_fun(k + 1, value + nums[k]);
            rec_fun(k + 1, value);

        }
    }
}
