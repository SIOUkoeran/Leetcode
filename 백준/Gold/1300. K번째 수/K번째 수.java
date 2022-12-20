
import java.util.*;
import java.io.*;

public class Main {
    static int N, k;
    static long answer;
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
    }
    private static void solution() {
        binarySearch();
        System.out.println(answer + 1);
    }
    private static void binarySearch() {
        long low = 1;
        long high = k;
        while (low < high) {
            long mid = (low + high) / 2;
            long cnt = calculate(mid);
            if (cnt < k) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid;
            }
        }
    }
    private static long calculate(long target) {
        long result = 0;
        for (int i = 1; i < N + 1; i++) {
            result += Math.min(target / i, N);
        }
        return result;
    }

}
