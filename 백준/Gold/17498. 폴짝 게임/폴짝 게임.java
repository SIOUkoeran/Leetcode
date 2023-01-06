import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
    static int N, M, D, ans = Integer.MIN_VALUE;
    static int[][] map, cost;
    public static void main(String[] args) throws Exception{
        input();
        solution();
        print();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cost[i], Integer.MIN_VALUE);
        }
        D = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() {
        System.out.println(ans);
    }

    /**
     * bfs 시작 위치 설정 0열에 있는 모든 지점 위치 시작
     */
    private static void solution() {
        for (int i = 0; i < M; i++) {
            ans = Math.max(ans, bfs(new Point(0, i)));
        }
    }

    /**
     * 해결함수 재귀
     * @param p
     */
    private static int bfs(Point p) {

        if (p.x == N - 1) {
            return 0;
        }
        /**
         * 범위확인
         */
        if (!isValidPos(p))
            return Integer.MIN_VALUE;

        /**
         * cost 배열에 값이 초기화되어있는지 확인
         */
        if (cost[p.x][p.y] != Integer.MIN_VALUE)
            return cost[p.x][p.y];

        /**
         * 배열 돌면서 재귀함수 들어가기
         */
        for (int i = p.x + 1; i < p.x + D + 1; i++) {
            for (int j = p.y - (D - (i - p.x)); j < p.y + (D - (i - p.x)) + 1; j++) {
                if (isMovePossible(p, i, j)) {
                    cost[p.x][p.y] = Math.max(cost[p.x][p.y], map[p.x][p.y] * map[i][j]
                    + bfs(new Point(i, j)));
                }
            }
        }
        return cost[p.x][p.y];
    }

    private static boolean isValidPos(Point p) {
        if (p.x < 0 || p.x >= N || p.y < 0 || p.y >= M)
            return false;
        return true;
    }
    private static boolean isMovePossible(Point p1, int p2x, int p2y) {
        if (p2y < 0 || p2x < 0 || p2y >= M || p2x >= N)
            return false;
        return p1.x < p2x && Math.abs(p1.x - p2x) + Math.abs(p1.y - p2y) <= D;
    }

    private static int calculate(Point p1, int p2x, int p2y) {
        return (map[p1.x][p1.y] * map[p2x][p2y]);
    }
}
