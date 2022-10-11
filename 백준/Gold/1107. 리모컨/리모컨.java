import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N , ans = 0;
    static Set<String> brokenButton;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        brokenButton = new HashSet<String>(){
            @Override
            public boolean equals(Object o) {
                return Integer.parseInt(o.toString()) == Integer.parseInt(this.toString());
            }
        };
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        if (count > 0)
            st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            brokenButton.add(st.nextToken());
        }
    }

    private static void solution() {
        ans = Math.abs(N - 100);
        if (brokenButton.size() == 10) {
            System.out.println(ans);
            return ;
        }
        for (int i = 0; i < 999_999; i++) {
            String numStr = String.valueOf(i);
            boolean flag = false;
            for (int j = 0; j < numStr.length(); j++) {
                if (brokenButton.contains(String.valueOf(numStr.charAt(j)))){
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                int temp = numStr.length();
                temp += Math.abs(N - Integer.parseInt(numStr));
                ans = Math.min(temp, ans);
            }
        }
        System.out.println(ans);
    }

}
