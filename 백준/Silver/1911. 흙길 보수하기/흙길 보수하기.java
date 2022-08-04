import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,L;
    static Pool[] pools;
    static class Pool implements Comparable<Pool>{
        int from;
        int to;

        public Pool(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Pool o) {
            if (this.to == o.to)
                return this.from - o.from;
            return this.to - o.to;
        }

        @Override
        public String toString() {
            return "Pool{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        solution();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        pools = new Pool[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            pools[i] = new Pool(from, to);
        }
    }
    static void solution() {
        int ans = 0;
        Arrays.sort(pools);
        int range = 0;
        for (int i = 0; i < N; i++) {
            Pool cur = pools[i];
            if (cur.from > range)
                range = cur.from;
            if (cur.to >= range)
                while (cur.to > range) {
                    range += L;
                    ++ans;
                }
        }
        System.out.println(ans);
    }
    static void layPlanks(int start, int[] planks){

    }
}