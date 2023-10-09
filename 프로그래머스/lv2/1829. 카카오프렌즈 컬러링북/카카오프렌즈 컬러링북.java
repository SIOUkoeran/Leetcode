import java.util.*;
import java.awt.Point;

class Solution {
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int ans = 1;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = picture[i][j];
                if (visited[i][j])
                    continue;
                if (color != 0) {
                    int area = calcArea(visited, picture, i, j);
                    ans = Math.max(area, ans);
                    ++cnt;
                }
            }
        }
        return new int[]{cnt, ans};
    }
    
   
    private int calcArea(boolean[][] visited, int[][] picture, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        int area = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < picture.length && nx >= 0 && ny < picture[0].length && ny >= 0) {
                    if (picture[nx][ny] == picture[cur.x][cur.y] && !visited[nx][ny]) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        ++area;
                    }
                }
            }
        }
        return area;
    }
}