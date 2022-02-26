import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        a = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a,1,N+ 1);
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
           int tempIdx = binarySearch(-a[i],i + 1);
           if (i + 1<= tempIdx && tempIdx <= N && answer > Math.abs(a[i] + a[tempIdx])){
               sb.setLength(0);
               answer = Math.abs(a[tempIdx] + a[i]);
               sb.append(a[i]).append(' ').append(a[tempIdx]);
           }
           if (i + 1<= tempIdx - 1 && tempIdx - 1 <= N && answer > Math.abs(a[i] + a[tempIdx - 1])){
               sb.setLength(0);
               answer = Math.abs(a[tempIdx - 1] + a[i]);
               sb.append(a[i]).append(' ').append(a[tempIdx - 1]);
           }
        }
        System.out.println(sb);
    }
    static int binarySearch(int value, int low){
        int high = a.length - 1;
        int mid;
        int answer = N + 1;
        while (low <= high){
            mid = (low + high) / 2;
            if (a[mid] >= value){
                high = mid - 1;
                answer = mid;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }
}
