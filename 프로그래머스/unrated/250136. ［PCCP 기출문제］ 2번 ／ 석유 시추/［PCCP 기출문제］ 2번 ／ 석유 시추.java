import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.awt.Point;
import java.util.Arrays;
class Solution {
    int id = 1;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    Map<Integer, Integer> oil;
    public int solution(int[][] land) {
        int answer = 0;
        oil = new HashMap<>();
        preCalculate(land);        
        answer = calculate(land);
        return answer;
    }
    
    private int calculate(int[][] land) {
        Set<Integer> set = new HashSet<>();
        int maxSum = -1;
        int answer = -1;
        for (int i = 0; i < land[0].length; i++) {
            int sum = 0;
            set.clear();
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] != 0) {
                    if (!set.contains(land[j][i])) {
                        set.add(land[j][i]);
                        sum += oil.get(land[j][i]);
                    }
                }
            }
            if (maxSum < sum) {
                answer = i;
                maxSum = sum;
            }
        }
        return maxSum;
    }
    
    private void preCalculate(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] != 0 && !visited[i][j]) {
                    calculate(land, visited, i, j);
                    ++id;
                }
            }
        }
    }
    
    private void calculate(int[][] land, boolean[][] visited, int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visited[i][j] = true;
        int sum = 1;
        land[i][j] = id;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length) {
                    if (!visited[nx][ny] && land[nx][ny] != 0) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        land[nx][ny] = id;
                        ++sum;
                    }
                }
            }
        }
        oil.put(id, sum);
    }
}