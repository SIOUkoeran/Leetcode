import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[] bottles;
    static boolean[] possible;
    static boolean[][][] visited;
    static class State{
        int[] x;
        State(int[] X){
            x = new int[3];
            for (int i = 0; i < 3; i++) {
                x[i] = X[i];
            }
        }
        State move(int from, int to, int[] limit){
            int[] nX = new int[]{x[0], x[1], x[2]};
            if (x[from] + x[to] >= limit[to]) {
                nX[from] -= limit[to] -nX[to];
                nX[to] = limit[to];
            }else{
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bottles = new int[3];
        for (int i = 0; i < 3; i++) {
            bottles[i] = Integer.parseInt(st.nextToken());
        }
        possible = new boolean[205];
        visited = new boolean[205][205][205];
        solution();
    }
    static void solution(){
        bfs(new State(new int[] {0,0,bottles[2]}));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= bottles[2]; i++) {
            if (possible[i]){
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }
    static void bfs(State state){
        Queue<State> q = new LinkedList<>();
        q.add(state);
        visited[state.x[0]][state.x[1]][state.x[2]] = true;
        while (!q.isEmpty()){
            State currentState = q.poll();
            if (currentState.x[0] == 0){
                possible[currentState.x[2]] = true;
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to){
                        continue;
                    }
                    State nextState = currentState.move(from, to, bottles);
                    if (!visited[nextState.x[0]][nextState.x[1]][nextState.x[2]]){
                            q.add(nextState);
                            visited[nextState.x[0]][nextState.x[1]][nextState.x[2]] = true;
                    }
                }
            }



        }
    }
}
