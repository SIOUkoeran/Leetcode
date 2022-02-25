import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        int answer;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int[] A,B;
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            A = new int[N + 1];
            B = new int[M + 1];
            answer = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            st= new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B, 1, M + 1);

            for (int j = 1; j < N + 1; j++) {
                answer += binarySearch(A[j],B,M);
            }
            System.out.println(answer);
        }
    }

    static int binarySearch(int value, int[] B, int M){
        int low = 1;
        int high = M;
        int answer = 0;
        while (low <= high){
            int mid = (high + low) / 2;
            if (B[mid] < value){
                answer = mid;
                low = mid + 1;
            }else if (B[mid] >= value){
                high = mid - 1;
            }
        }
        return answer;
    }
}
