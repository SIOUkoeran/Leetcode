import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static LinkedList<Integer>[] gear;
    private static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        gear = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            gear[i] = new LinkedList<>();
        }
        int tempNum;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            String s = String.valueOf(st.nextToken());
            for (int j = 0; j < 8; j++) {
                tempNum = Integer.parseInt(String.valueOf(s.charAt(j)));
                gear[i].add(tempNum);
            }
        }
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        int direction[] = new int[4];
        int result = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            direction = solution(idx - 1, dir);
            result = calculate(direction);
        }
        System.out.println(result);
    }
    /**
     * left 6
     * right 2
     * @param idx
     * @param dir
     */
    private static int[] solution(int idx, int dir) {
        int tempIdx = idx;
        int direction[] = new int[4];
        Arrays.fill(direction, 0);
        direction[idx] = dir;
        while (tempIdx > 0){
            if (!gear[tempIdx - 1].get(2).equals(gear[tempIdx].get(6))){
                direction[tempIdx - 1] = direction[tempIdx] * -1;
            }else {
                direction[tempIdx - 1] = 0;
                break;
            }
            tempIdx--;
        }
        tempIdx = idx;
        while (tempIdx < 3){
            if (!gear[tempIdx].get(2).equals(gear[tempIdx + 1].get(6))){
                direction[tempIdx + 1] = direction[tempIdx] * -1;
            }else{
                direction[tempIdx + 1] = 0;
                break;
            }
            tempIdx++;
        }
        return direction;
    }
    private static int calculate(int[] direction){
        int result = 0;
        int temp;
        for (int i = 0; i < 4; i++) {
            if (direction[i] == -1) {
                temp = Objects.requireNonNull(gear[i].poll());
                gear[i].addLast(temp);
            }else if (direction[i] == 1){
                temp = gear[i].pollLast();
                gear[i].addFirst(temp);
            }
        }
        for (int i = 0; i < 4; i++) {
            result += gear[i].get(0) * Math.pow(2,i);
        }
        return result;
    }
}

