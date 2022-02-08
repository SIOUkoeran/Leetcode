import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map;
    private static int answer;
    private static Queue<SharkInfo> queue = new LinkedList<>();
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,-1,0,1};
    private static boolean[][] visited;
    private static ArrayList<SharkInfo> tempArrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        answer = 0;
        SharkInfo startShark = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9){
                    queue.add(new SharkInfo(i,j,2,0));
                    startShark = new SharkInfo(i,j,2,0);
                    map[i][j] = 0;
                }
            }
        }
        tempArrayList = new ArrayList<>();
        SharkInfo fish;
        SharkInfo tempShark = null;
        boolean flag;
        int numberOfEat = 0;
        while (true){
            flag = false;
            visited = new boolean[n][n];
            bfs();
            int dist = 987654321;
            for (int i = 0; i < tempArrayList.size(); i++) {
                fish = tempArrayList.get(i);
                if (dist > Math.abs(startShark.time - fish.time)){
                    dist =  Math.abs(startShark.time - fish.time);
                    tempShark = fish;
                    flag = true;
                }else if (dist ==  Math.abs(startShark.time - fish.time)){
                    if (tempShark.x > fish.x){
                            tempShark =fish;
                            flag = true;
                    } else if (tempShark.x == fish.x){
                        if (tempShark.y > fish.y){
                            tempShark = fish;
                            flag = true;
                        }
                    }
                }
            }
            if (!flag){
                System.out.println(answer);
                return ;
            }
            numberOfEat++;
            if (tempShark.size == numberOfEat){
                tempShark.size++;
                numberOfEat = 0;
            }
            queue.add(tempShark);
            answer = tempShark.time;
            map[tempShark.x][tempShark.y] = 0;
            tempArrayList.clear();
            startShark = tempShark;
        }
    }

    private static void bfs(){
        while(!queue.isEmpty()){
            SharkInfo curPos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if ((map[nx][ny] == 0 || map[nx][ny] == curPos.size) && !visited[nx][ny]) {
                        queue.add(new SharkInfo(nx, ny, curPos.size, curPos.time + 1));
                        visited[nx][ny] = true;
                    }
                    if (map[nx][ny] > 0 && map[nx][ny] < curPos.size && !visited[nx][ny]) {
                        tempArrayList.add(new SharkInfo(nx, ny, curPos.size, curPos.time + 1));

                    }
                }
            }

        }
    }
    private static class SharkInfo{
        private int x;
        private int y;
        private int size;
        private int time;
        public SharkInfo(int x, int y, int size, int time){
            this.x = x;
            this.y= y;
            this.size = size;
            this.time = time;
        }

        @Override
        public String toString() {
            return "SharkInfo{" +
                    "x=" + x +
                    ", y=" + y +
                    ", size=" + size +
                    ", time=" + time +
                    '}';
        }
    }
}
