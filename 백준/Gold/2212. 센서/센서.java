import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, K;
    static int[] censors;
    public static void main(String[] args) throws IOException{
        input();
        solution();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        censors = new int[N];
        for (int i = 0; i < N; i++) {
            censors[i] = Integer.parseInt(st.nextToken());
        }
    }
    static void solution() {
        if (K >= N){
            System.out.println(0);
            return ;
        }
        Integer[] dist = new Integer[N - 1];
        Arrays.sort(censors);
        int ans = 0;
        for (int i = 1; i < N; i++) {
            dist[i - 1] = censors[i] - censors[i - 1];
        }
        Arrays.sort(dist, Collections.reverseOrder());
        for (int i = 0; i < K - 1; i++) {
            dist[i] = 0;
        }
        for (int i = 0; i < N - 1; i++) {
            ans += dist[i];
        }
        System.out.println(ans);
    }
}