
import java.util.*;
import java.io.*;

public class Main {
    static class City{
        int people;
        int to;
        public City(int people, int to) {
            this.people = people;
            this.to = to;
        }
    }
    static int N, sum = 0, answer = Integer.MAX_VALUE;
    static LinkedList<City>[] graph;
    static int[] cityPeople;
    static List<Integer> set = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new LinkedList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        st = new StringTokenizer(br.readLine());
        cityPeople = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            cityPeople[i] = Integer.parseInt(st.nextToken());
            sum += cityPeople[i];
        }
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int connect = Integer.parseInt(st.nextToken());
            for (int j = 0; j < connect; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph[i].add(new City(cityPeople[next], next));
            }
        }
    }
    private static void solution() {
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            comb(N + 1, visited, 1, i);
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static void comb(int n, boolean[] visited, int depth, int r) {
        if (r == 0) {
            if (isConnected(visited))
                answer = Math.min(calculate(visited), answer);
        }
        if (depth == n)
            return;
        visited[depth] = true;
        comb(n, visited, depth + 1, r - 1);
        visited[depth] = false;
        comb(n, visited, depth + 1, r - 1);
    }

    /**
     * 지역구 합 차이 계산
     * @param visited
     * @return
     */
    private static int calculate(boolean[] visited) {
        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            if (visited[i])
                result += cityPeople[i];
        }
        return Math.abs(sum - 2 * result);
    }

    /**
     * 2개의 지역구 연결되어있는지 확인
     * @param visited
     * @return
     */
    private static boolean isConnected(boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedA = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (visited[i]) {
                visitedA[i] = true;
                q.add(i);
                break;
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (City nextCity : graph[cur]) {
                if (visited[nextCity.to] && !visitedA[nextCity.to]) {
                    q.add(nextCity.to);
                    visitedA[nextCity.to] = true;
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                visitedA[i] = true;
                q.add(i);
                break;
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (City nextCity : graph[cur]) {
                if (!visited[nextCity.to] && !visitedA[nextCity.to]) {
                    q.add(nextCity.to);
                    visitedA[nextCity.to] = true;
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if (!visitedA[i])
                return false;
        }
        return true;
    }
}
