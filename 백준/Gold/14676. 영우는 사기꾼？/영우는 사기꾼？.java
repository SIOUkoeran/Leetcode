import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static LinkedList<Integer>[] tree;
    static int[] Indeg,cnt,check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tree = new LinkedList[N + 1];
        check = new int[N + 1];
        cnt = new int[N + 1];
        Indeg = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            Indeg[y]++;
        }
        boolean c = false;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1){
                if (check[b] < Indeg[b]){
                    c = true;
                }
                cnt[b]++;
                if (cnt[b] == 1){
                    for (int y : tree[b]){
                        check[y]++;
                    }
                }
            }
            else{
                if (cnt[b] == 0){
                    c = true;
                }
                cnt[b]--;
                if (cnt[b] == 0){
                    for (int y : tree[b]){
                        check[y]--;
                    }
                }
            }
        }
        if (c){
            System.out.println("Lier!");
            return;
        }
        System.out.println("King-God-Emperor");
    }
}
