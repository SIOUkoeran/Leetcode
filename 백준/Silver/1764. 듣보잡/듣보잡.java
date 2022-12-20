

import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, answer = 0;
    static List<String> noHeard = new ArrayList<>();
    static List<String> noSeen = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            noHeard.add(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            noSeen.add(st.nextToken());
        }
        Collections.sort(noHeard);
        Collections.sort(noSeen);
    }

    private static void solution(){
        for (int i = 0; i < N; i++) {
            binarySearch(noHeard.get(i));
        }
        System.out.println(answer);
        System.out.println(sb);
    }
    private static void binarySearch(String target) {
        int low = 0;
        int high = noSeen.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (noSeen.get(mid).compareTo(target) > 0) {
                high = mid - 1;
            }else if (noSeen.get(mid).compareTo(target) == 0) {
                ++answer;
                sb.append(target).append("\n");
                return ;
            } else {
                low = mid + 1;
            }
        }
    }
}
