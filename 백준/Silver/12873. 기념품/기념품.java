

import java.util.*;
import java.io.*;

public class Main {
    static long N;
    static ArrayList<Integer> people = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        for (int i = 0; i < N; i++) {
            people.add(i + 1);
        }
    }

    private static void solution(){
        long cnt = 0;
        int cur = 0;
        while (people.size() > 1) {
            long round = square3(++cnt);
            int total = people.size();
            cur += ((round % total) + (total - 1)) % total;
            cur %= total;
            people.remove(cur);
        }
        System.out.println(people.get(0));
    }
    private static long square3(long n) {
        return (long) n * n * n;
    }
}
