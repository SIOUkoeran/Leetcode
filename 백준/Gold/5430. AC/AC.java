
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static Character[] command = new Character[2];
    static int T, inputArrayLength;
    static boolean flag, isReversed;
    static String inputCommand;
    static String[] inputArray;
    static List<String> inputList;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws Exception{
        input();
        print();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        command[0] = 'R';
        command[1] = 'D';
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            inputCommand = st.nextToken();
            st = new StringTokenizer(br.readLine());
            inputArrayLength = Integer.parseInt(st.nextToken());
            inputArray = new String[inputArrayLength];
            st = new StringTokenizer(br.readLine());
            if (inputArrayLength != 0){
                inputArray = st.nextToken().replaceAll("[\\[|\\]]", "").split(",");
                inputList = Arrays.stream(inputArray).collect(Collectors.toList());

            }else{
                inputList = new ArrayList<>();
            }
            solution();
        }
    }

    private static void solution() {
        isReversed = false;
        flag = false;
        for (int i = 0; i < inputCommand.length(); i++) {
            if (flag)
                break;
            Character curCommand = inputCommand.charAt(i);
            if (curCommand == command[0]) {
                actionCommand0();
            }else if (curCommand == command[1]) {
                actionCommand1();
            }
        }
        if (flag)
            sb.append("error").append("\n");
        else {
            sb.append("[");
            if (isReversed){
                Collections.reverse(inputList);
            }
            for (int i = 0; i < inputList.size(); i++) {
                sb.append(inputList.get(i));
                if (i != inputList.size() - 1)
                    sb.append(",");
            }
            sb.append("]").append("\n");
        }
    }

    /**
     * command 행렬 0번째 실행
     */
    private static void actionCommand0() {
        isReversed = !isReversed;
    }

    /**
     * command 행렬 1번째 실행
     */
    private static void actionCommand1() {
        if (!inputList.isEmpty()) {
            if (isReversed)
                inputList.remove(inputList.size() - 1);
            else
                inputList.remove(0);
        }else{
            flag = true;
        }
    }

    private static void print() {
        System.out.println(sb);
    }
}
