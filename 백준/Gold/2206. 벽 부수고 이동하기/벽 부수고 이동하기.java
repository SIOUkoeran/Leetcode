
import java.util.*;
import java.io.*;

public class Main {
    static class Info{
        int x, y;
        int cnt;
        int walks;
        public Info(int x, int y, int cnt, int walks) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.walks = walks;
        }
    }
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j)- '0';
            }
        }
    }

    private static void solution() {
        Queue<Info> q = new LinkedList<>();
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], 3);
        }
        q.add(new Info(0,0, 0, 1));
        visited[0][0] = 0;
        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Info cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    /**
                     * 벽을 깬 횟수가 0이고 다음이 벽일 때.
                     **/
                        if (visited[nx][ny] <= cur.cnt) continue;
                        /**
                         * 도착지에 도착했을 때
                         */
                        if (nx == N - 1 && ny == M - 1) {
                            answer = Math.min(answer, cur.walks + 1);
                        }
                        /**
                         * 벽을 깨고 갈 때
                         */
                        if (cur.cnt == 0 && map[nx][ny] == 1){
                            q.add(new Info(nx, ny, 1, cur.walks + 1));
                            visited[nx][ny] = cur.cnt + 1;
                        }
                        /**
                         * 벽을 깨지 못할 때
                         */
                        if (map[nx][ny] == 0) {
                            q.add(new Info(nx, ny, cur.cnt, cur.walks + 1));
                            visited[nx][ny] = cur.cnt;
                        }
                }
            }

        }
        answer = Integer.MAX_VALUE == answer
            ? -1
            : answer;
        if (N == 1 && M == 1){
            System.out.println(1);
            return;
        }
        System.out.println(answer);
    }
}
