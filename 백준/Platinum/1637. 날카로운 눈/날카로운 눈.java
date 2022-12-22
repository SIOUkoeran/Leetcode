
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
    static int[] A,B,C;
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[i] = a;
            B[i] = b;
            C[i] = c;
            min = Math.min(A[i], min);
            max = Math.max(C[i], max);
        }
    }
    private static void solution() {
        binarySearch();
    }
    private static void binarySearch() {
        long low = min;
        long high = ++max;
        while (low < high) {
            long mid = (low + high) / 2;
            if (getCnt(mid) % 2 == 0) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        if (low == max)
            System.out.println("NOTHING");
        else
            System.out.println(low + " " + (getCnt(low) - getCnt(low - 1)));
    }
    private static long getCnt(long mid) {
        long result = 0;
        for (int i = 0; i < N; i++) {
            if (mid >= A[i]) {
                result += (Math.min(mid, C[i]) - A[i]) / B[i] + 1;
            }
        }
        return result;
    }
}
