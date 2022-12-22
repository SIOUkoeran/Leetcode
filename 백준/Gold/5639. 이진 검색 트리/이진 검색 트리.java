
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer> tree = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = null;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            tree.add(Integer.parseInt(st.nextToken()));
        }

    }
    private static void solution() {
        treeTraversal(0, tree.size() - 1);
        System.out.println(sb);
    }
    private static void treeTraversal(int left, int right) {
        if (left > right) {
            return;
        }
        int mid = right;
        for (int i = left + 1; i <= right; i++) {
            if (tree.get(i) > tree.get(left)){
                mid = i - 1;
                break;
            }
        }
        treeTraversal(left + 1, mid);
        treeTraversal(mid + 1, right);
        sb.append(tree.get(left)).append("\n");
    }
}
