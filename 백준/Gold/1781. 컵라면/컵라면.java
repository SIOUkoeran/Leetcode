import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Homework[] inputs;
    static class Homework implements Comparable<Homework>{
        int num;
        int cost;
        int deadline;

        public Homework(int num, int cost, int deadline) {
            this.num = num;
            this.cost = cost;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(Homework o) {
//            if ((float) this.cost / (float) deadline > (float) o.cost / (float)deadline){
//                return -1;
//            }else if ((float) this.cost /  (float)deadline == (float) o.cost /  (float)deadline)
//                return 0;
//            return 1;
            return this.deadline - o.deadline;
        }

        @Override
        public String toString() {
            return "Homework{" +
                    "num=" + num +
                    ", cost=" + cost +
                    ", deadline=" + deadline +
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
        inputs = new Homework[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            inputs[i] = new Homework(i + 1, cost, deadLine);
        }
    }
    static void solution() {
        Arrays.sort(inputs);
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            q.add(inputs[i].cost);
            while (q.size() > inputs[i].deadline){
                q.poll();
            }
        }
        while(!q.isEmpty()){
            ans += q.poll();
        }
        System.out.println(ans);
    }
}