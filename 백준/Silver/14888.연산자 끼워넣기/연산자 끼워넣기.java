import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] nums, op, order;
    private static int max, min;
    private static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        nums = new int[N + 1];
        op = new int [5];
        order = new int[N + 1];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        rec_fun(1);
        System.out.println(max);
        System.out.println(min);
    }
    static int calculator(){
        int value = nums[1];
        for (int i = 1; i < N ; i++) {
            if (order[i] == 1){
                value = value + nums[i + 1];
            }
            else if (order[i] == 2){
                value = value - nums[i + 1];
            }
            else if (order[i] == 3){
                value = value * nums[i + 1];
            }
            else if (order[i] == 4){
                value = value / nums[i + 1];
            }
        }
        return value;
    }
    static void rec_fun(int k){
        int value = 0;
        if (k == N){
            value = calculator();
            max = Math.max(max,value);
            min = Math.min(min, value);
        }else{
            for (int i = 1; i <= 4; i++) {
                if (op[i] >= 1){
                    op[i]--;
                    order[k] = i;
                    rec_fun(k + 1);
                    op[i]++;
                    order[k] = 0;
                }
            }
        }
    }
}
