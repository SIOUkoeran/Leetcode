import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = 0;
    static Flower[] flowers;
    static class Flower implements Comparable<Flower> {
        int[] from = new int[2];
        int[] to = new int[2];
        public Flower(int from1, int from2, int to1, int to2) {
            this.from = new int[]{from1, from2};
            this.to = new int[]{to1, to2};

        }

        int getFrom() {
            return from[0] * 100 + from[1];
        }

        int getTo() {
            return to[0] * 100 + to[1];
        }

        @Override
        public int compareTo(Flower o2) {
            int diff = (this.from[0] * 100 + this.from[1])
                - (o2.from[0] * 100 + o2.from[1]);
            if (diff == 0)
                return (this.to[0] * 100 + this.to[1])
                    - (o2.to[0] * 100 + o2.to[1]);
            return diff;
        }

        @Override
        public String toString() {
            return " from " + getFrom()
                + " to " + getTo();
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        flowers = new Flower[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from1 = Integer.parseInt(st.nextToken());
            int from2 = Integer.parseInt(st.nextToken());
            int to1 = Integer.parseInt(st.nextToken());
            int to2 = Integer.parseInt(st.nextToken());
            Flower flower = new Flower(from1, from2, to1, to2);
            flowers[i] = flower;
        }
        Arrays.sort(flowers);
    }

    private static void solution() {
        int day = 301;
        final int finalDay = 1201;
        int max = Integer.MIN_VALUE, lastIdx = 0;
        boolean flag;
        while (day < finalDay) {
            flag = false;
            for (int i = lastIdx; i < N; i++) {
                if (flowers[i].getFrom() > day) break;
                if (flowers[i].getTo() > max){
                    max = flowers[i].getTo();
                    flag = true;
                    lastIdx = i + 1;
                }
            }
            if (!flag){
                break;
            }
            ++answer;
            day = max;
        }
        answer = max < 1201
            ? 0
            : answer;
    }

}
