import java.awt.SystemTray;
import java.util.*;
import java.io.*;

public class Main {
    static int[] ball;
    static int N, answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ball = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ball[i] = Integer.parseInt(st.nextToken());
        }
    }
    private static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 4; j++) {
                    int color = ball[i];
                    ball[i] = j;
                    answer = Math.min(answer, deleteBall(i, i, N));
                    ball[i] = color;
            }
        }
        System.out.println(answer);
    }

    /**
     * 재귀함수를 통해 볼 카운트
     * @param l
     * @param r
     * @param left
     * @return
     */
    private static int deleteBall(int l, int r, int left) {
        if (left < 4)
            return left;
        if (l < 0 || r > N)
            return left;
        if (ball[l] != ball[r])
            return left;
        int cnt = 0;
        int prevLeft = l;
        int prevRight = r;
        for (int i = l; i >= 0; i--) {
            if (ball[i] != ball[l]) {
                l = i;
                break;
            }
            ++cnt;
        }
        for (int i = r; i < N; i++) {
            if (ball[i] != ball[r]){
                r = i;
                break;
            }
            ++cnt;
        }
        cnt = prevLeft == prevRight
            ? cnt - 1
            : cnt;
        if (cnt < 4)
            return left;
        left = left - cnt;
        return deleteBall(l, r, left);
    }
}
