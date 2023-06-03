import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.sort;

public class Main {

    static int n;

    static int[] array;

    static List<Integer> result;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }
        result = new ArrayList<>();
    }

    private static void solution() {
        result.add(array[0]);
        for (int i = 1; i < n; i++) {
            int targetNum = array[i];
            if (targetNum > result.get(result.size() - 1))
                result.add(targetNum);
            else {
                binarySearch(targetNum);
            }
        }
        System.out.println(calcMaxLength());
    }

    private static void binarySearch(int target) {
        int low = 0;
        int high = result.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (result.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        result.set(high, target);
    }

    private static int calcMaxLength() {
        return result.size();
    }
}