import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.sort;

public class Main {

    static int n;

    static int result = 0;
    static List<LectureInfo> lectureInfoList;

    static class LectureInfo implements Comparable {
        int days;
        int costs;

        public LectureInfo(int days, int costs) {
            this.days = days;
            this.costs = costs;
        }

        @Override
        public int compareTo(Object o) {
            LectureInfo lo = (LectureInfo) o;
            if (lo.days == this.days)
                return lo.costs - this.costs;
            else
                return this.days - lo.days;
        }

        @Override
        public String toString() {
            return "days : " + days
                    + " costs : " + costs;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        lectureInfoList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int costs = Integer.parseInt(st.nextToken());
            int days = Integer.parseInt(st.nextToken());
            lectureInfoList.add(new LectureInfo(days, costs));
        }
        sort(lectureInfoList);
    }

    private static void solution() {
        int result = calcMaxCosts();
        System.out.println(result);
    }

    private static int calcMaxCosts() {
        if (n == 0)
            return 0;
        int days = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (LectureInfo lectureInfo : lectureInfoList) {
            // 현재 날짜가 lectureInfo 보다 클 때,
            if (days > lectureInfo.days) {
                queue.offer(lectureInfo.costs);
            } else {
                days = lectureInfo.days;
                queue.offer(lectureInfo.costs);
                while (queue.size() > days) {
                    queue.poll();
                }
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result;
    }
}