import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int cnt = 0;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1];
        rec_fun(1);
        System.out.println(cnt);
    }
    static void rec_fun(int k){
        if (k == N + 1){
            ++cnt;
        }else{
            for(int i = 1; i < N + 1; i++){
                if (checkRow(map,i,k) && checkCross(map,i,k)){
                    map[k] = i;
                    rec_fun(k + 1);
                    map[k] = 0;
                }
            }
        }
    }
    static boolean checkRow(int[] map, int value, int idx){
        for (int i = 1; i <= idx; i++) {
            if (map[i] != 0 && i != idx && map[i] == value){
                return false;
            }
        }
        return true;
    }
    static boolean checkCross(int[] map, int value, int idx){
        for(int i = 1; i < N + 1; i++){
            if (map[i] != 0 && idx != i){
               if (Math.abs(i - idx) == Math.abs(value - map[i])){
                   return false;
               }
            }
        }
        return true;
    }
}
