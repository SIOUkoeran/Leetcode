import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Elem[] nums;
    static int[] tempNums;
    static class Elem implements Comparable<Elem>{
        int value;
        int idx;

        @Override
        public int compareTo(Elem o) {
            if (value != o.value)
                return value - o.value;
            return idx - o.idx;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new Elem[N];
        tempNums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            nums[i] = new Elem();
            nums[i].value = temp;
            nums[i].idx = i;
        }
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            tempNums[nums[i].idx] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(tempNums[i]).append(' ');
        }
        System.out.println(sb);
    }
}
