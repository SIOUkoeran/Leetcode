import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int E,S,M;
    static Map<String, Integer> cycle = new HashMap<>();
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    private static void solution() {
        cycle.put("earth", 15);
        cycle.put("sun", 28);
        cycle.put("moon", 19);
        long ans = 0;
        int[] calendar = new int[3];
        while (true) {
            ++ans;
            ++calendar[0];
            ++calendar[1];
            ++calendar[2];
            if (calendar[0] > getCycle("earth"))
                calendar[0] = 1;
            if (calendar[1] > getCycle("sun"))
                calendar[1] = 1;
            if (calendar[2] > getCycle("moon"))
                calendar[2] = 1;

            if (calendar[0] == E && calendar[1] == S && calendar[2] == M)
                break;
        }
        System.out.println(ans);
    }

    private static int getCycle(String key) {
        return cycle.get(key);
    }

}
