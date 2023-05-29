import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] initArray1;
    static int[] initArray2;
    static int[] expectedArray;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        initArray1 = new int[n];
        expectedArray = new int[n];
        st = new StringTokenizer(br.readLine());
        String line = st.nextToken();
        for (int i = 0; i < n; i++) {
            initArray1[i] = line.charAt(i) - '0';
        }
        initArray2 = Arrays.copyOf(initArray1, n);
        st = new StringTokenizer(br.readLine());
        line = st.nextToken();
        for (int i = 0; i < n; i++) {
            expectedArray[i] = line.charAt(i) - '0';
        }
        initArray2[0] = initArray2[0] == 1
                ? 0
                : 1;
        initArray2[1] = initArray2[1] == 1
                ? 0
                : 1;
    }

    /**
     * -1 -1
     * -1  2
     *  2  3
     *  2 -1
     */

    private static void solution() {
        // 1번째 전구 상태를 바꾸지않고 진행
        int cnt1 = isSwitchBulb(1, initArray1, 0);
        // 1번째 전구 상태를 바꾸고 진행
        int cnt2 = isSwitchBulb(1, initArray2, 1);
        int result = Math.min(cnt1, cnt2);
        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    private static int isSwitchBulb(int idx, int[] array, int startCnt) {
        int cnt = startCnt;
        for (int i = 1; i < array.length; i++) {
            if (checkBulb(array)) {
                return cnt;
            }
            // 앞 전구 상태가 다를 때
            if (array[i - 1] != expectedArray[i - 1]) {
                turnOnOrOffBulb(i, array);
                ++cnt;
            }
        }
        if (checkBulb(array))
            return cnt;
        return Integer.MAX_VALUE;
    }

    private static void turnOnOrOffBulb(int idx, int[] array) {
        if (idx < array.length - 1) {
            array[idx - 1] = changeBulbStatus(array[idx - 1]);
            array[idx] = changeBulbStatus(array[idx]);
            array[idx + 1] = changeBulbStatus(array[idx + 1]);
        } else {
            array[idx - 1] = changeBulbStatus(array[idx - 1]);
            array[idx] = changeBulbStatus(array[idx]);
        }
    }

    // 현 상태의 array 가 expectedArray 와 같은 상태인지 파악.
    private static boolean checkBulb(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != expectedArray[i])
                return false;
        }
        return true;
    }

    /**
     * change status
     *
     * @param value 현재 전구 상태
     * @return 변경된 전구 상태
     */
    private static int changeBulbStatus(int value) {
        return value == 1
                ? 0
                : 1;
    }
}