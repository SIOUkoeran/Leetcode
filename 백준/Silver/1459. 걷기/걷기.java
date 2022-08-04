import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static long X, Y, W, S, ans;
    public static void main(String[] args) throws IOException{
        input();
        solution();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        W = Long.parseLong(st.nextToken());
        S = Long.parseLong(st.nextToken());
        ans = 0;
    }
    static void solution() {
        long onlyWalk = (X + Y) * W;
        long onlyCross = (X + Y) % 2 == 0
                ? Math.max(X, Y) * S
                : (Math.max(X, Y) - 1) * S + W;
        long combineWalkAndOnlyCross = Math.min(X, Y) * S + Math.abs(X - Y) * W;
        ans = Math.min(Math.min(onlyWalk, onlyCross), combineWalkAndOnlyCross);
        System.out.println(ans);
    }

}