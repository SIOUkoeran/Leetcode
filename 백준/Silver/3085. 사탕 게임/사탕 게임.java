import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char map[][];
    static int N;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
    }

    private static void solution() {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N - 1; k++) {
                        swap(j, k, j, k + 1);
                        calculate();
                        swap(j, k, j, k + 1);
                }       
            }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                    swap(j, i, j + 1, i);
                    calculate();
                    swap(j, i, j + 1, i);
            }
        }
        System.out.println(answer);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp;
        temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    private static void calculate() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1])
                    ++cnt;
                else
                    cnt = 1;
                answer = Math.max(cnt, answer);
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i])
                    ++cnt;
                else
                    cnt = 1;
                answer = Math.max(cnt, answer);
            }
        }
    }
}
