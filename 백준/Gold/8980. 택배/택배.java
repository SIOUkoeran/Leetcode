import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,C,M;
    static Info[] infos;
    static class Info implements Comparable<Info>{
        int from;
        int to;
        int capacity;

        public Info(int from, int to, int capacity) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
        }

        @Override
        public int compareTo(Info o) {
            if (this.to == o.to){
                return this.from - o.from;
            }
            return this.to - o.to;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "from=" + from +
                    ", to=" + to +
                    ", capacity=" + capacity +
                    '}';
        }
    }
    static class Delivery implements Comparable<Delivery>{
        int to;
        int boxes;

        public Delivery(int to, int boxes) {
            this.to = to;
            this.boxes = boxes;
        }

        @Override
        public int compareTo(Delivery o) {
            return this.boxes - o.boxes;
        }

        @Override
        public String toString() {
            return "Delivery{" +
                    "to=" + to +
                    ", boxes=" + boxes +
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
        C = Integer.parseInt(st.nextToken());
        st =  new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        infos = new Info[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());
            infos[i] = new Info(from, to, capacity);
        }
    }
    static void solution() {
        int[] weight = new int[N + 1];
        int ans = 0;

        Arrays.sort(infos);
        Arrays.fill(weight, C);

        for (int i = 0; i < M; i++) {
            Info cur = infos[i];
            int min = Integer.MAX_VALUE;
            for (int j = cur.from; j < cur.to; j++) {
                min = Math.min(min, weight[j]);
            }
            int delivery = Math.min(min, cur.capacity);
            ans += delivery;
            for (int j = cur.from; j < cur.to; j++) {
                weight[j] -= delivery;
            }
        }
        System.out.println(ans);
    }
}