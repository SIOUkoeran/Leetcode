import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] dot;

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dot = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dot[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            
            dot[color].add(point);
        }
        // TODO: 정렬
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(dot[i]);
            for (int j = 0; j < dot[i].size(); j++) {
                 int toLeft = toLeft(i, j);
                 int toRight = toRight(i,j);
                 answer += Math.min(toLeft, toRight);
            }
        }
        System.out.println(answer);
    }
    static int toLeft(int color, int idx){
        if (idx == 0){
            return Integer.MAX_VALUE;
        }
        return dot[color].get(idx) - dot[color].get(idx - 1);
    }
    static int toRight(int color, int idx){
        if (idx == dot[color].size() - 1){
            return Integer.MAX_VALUE;
        }
        return dot[color].get(idx + 1) - dot[color].get(idx);
    }
}
