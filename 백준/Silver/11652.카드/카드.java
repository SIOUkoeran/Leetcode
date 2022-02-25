import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] cards;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cards = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st= new StringTokenizer(br.readLine());
            cards[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(cards, 1, N + 1);
        long max = cards[1];
        int currentCnt = 1;
        int totalCnt = 1;
        for (int i = 2; i < N + 1; i++) {
            if (cards[i - 1] == cards[i]){
                currentCnt++;
            }else{
                currentCnt = 1;
            }
            if (totalCnt < currentCnt){
                max = cards[i];
                totalCnt = currentCnt;
            }
        }
        System.out.println(max);
    }
}
