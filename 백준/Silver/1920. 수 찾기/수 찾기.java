

import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] A,B;
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
    }

    private static void solution(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(B[i])).append("\n");
        }
        System.out.println(sb);
    }
    private static int binarySearch(int target) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] > target) {
                high = mid - 1;
            }else if (A[mid] == target) {
              return 1;
            } else {
                low = mid + 1;
            }
        }
        return A[low] == target ? 1 : 0;
    }
}
