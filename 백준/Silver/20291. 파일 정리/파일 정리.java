
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] files;
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        files = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            files[i] = st.nextToken().split("\\.")[1];
        }
        Arrays.sort(files);
    }
    private static void solution() {
        int ans = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            if (files[i - 1].equals(files[i])){
                ++ans;
            }else{
                sb.append(files[i - 1]).append(" ").append(ans).append("\n");
                ans = 1;
            }
        }
        sb.append(files[N - 1]).append(" ").append(ans);
        System.out.println(sb);
    }
}
