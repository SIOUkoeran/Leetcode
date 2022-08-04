import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, ans;
    static int[] judgePosition, dist;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        input();
        solution();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        judgePosition = new int[K];
        for (int i = 0; i < K; i++) {
            judgePosition[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
    }
    static void solution() {
        binarySearch(0, N);
        int cur = 0, cnt = 0;
        for (int i = 0; i < judgePosition.length; i++) {
            if (cur <= judgePosition[i] && cnt < M){
                sb.append("1");
                cur = judgePosition[i] + ans;
                ++cnt;
            }else{
                sb.append("0");
            }
        }
        System.out.println(sb);
    }
    static void binarySearch(int start, int end){
        while (start <= end){
            int mid = (start + end) / 2;

            if (count(mid)){
                start = mid + 1;
                ans = Math.max(mid, ans);
            }else{
                end = mid - 1;
            }
        }
    }
    static boolean count(int mid){
        int cnt = 0;
        int cur = 0;
        for (int i = 0; i < judgePosition.length; i++) {
            if (cur <= judgePosition[i]){
                ++cnt;
                cur = judgePosition[i] + mid;
            }
        }
        return cnt >= M;
    }

}