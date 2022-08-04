import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, P;
    static Info[] infos;
    static class Info implements Comparable<Info>{
        int dist;
        int gas;
        public Info(int dist, int gas) {
            this.dist = dist;
            this.gas = gas;
        }

        @Override
        public int compareTo(Info o) {
            if (dist == o.dist)
                return this.gas - o.gas;
            return dist - o.dist;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "dist=" + dist +
                    ", gas=" + gas +
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
        infos = new Info[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int gas = Integer.parseInt(st.nextToken());
            infos[i] = new Info(dist, gas);
        }
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
    }
    static void solution() {
        int ans = 0;
        Arrays.sort(infos);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cur = 0;
        while (P < L){
            for (int i = cur; i < N; i++) {
                if (infos[i].dist != 0 && infos[i].dist <= P){
                    pq.add(infos[i].gas);
                    cur = i + 1;
                }
            }
            if (pq.isEmpty())
            {
                System.out.println(-1);
                return ;
            }
            P += pq.poll();
            ++ans;
        }
        System.out.println(ans);
    }

}