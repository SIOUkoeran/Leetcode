import java.awt.Point;
class Solution {
    private int[][] matrix;
    private boolean[][] visited;
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        this.visited = new boolean[matrix.length][matrix[0].length];
        int startX = 0, startY = -1;
        Point point = null;
        while (true) {
            point = rightMove(startX, startY + 1);
            if (point.x + 1 >= matrix.length) break;
            if (visited[point.x + 1][point.y])
                break;
            point = downMove(point.x + 1, point.y);
            if (point.y - 1 < 0) break;
            if (visited[point.x][point.y - 1])
                break;
            point = leftMove(point.x, point.y - 1);
            if (point.x - 1 < 0) break;
            if (visited[point.x - 1][point.y])
                break;
            point = upMove(point.x - 1, point.y);
            if (point.y + 1 >= matrix[0].length) break;
            if (visited[point.x][point.y + 1])
                break;
            startX = point.x;
            startY = point.y;
        }
        
        return this.ans;
    }
    
    
    private Point rightMove(int startX, int startY) {
        for (int i = startY; i < matrix[0].length; i++) {
            System.out.println(i);
            if (visited[startX][i])
                return new Point(startX, i - 1);
            this.visited[startX][i] = true;
            this.ans.add(matrix[startX][i]);
        }
        return new Point(0, matrix[0].length - 1);
    }
    
    private Point leftMove(int startX, int startY) {
        for (int i = startY; i >= 0; i--) {
            if (visited[startX][i])
                return new Point(startX, i + 1);
            this.visited[startX][i] = true;
            this.ans.add(matrix[startX][i]);
        }
        return new Point(matrix.length - 1, 0);
    }
    
    private Point upMove(int startX, int startY) {
        for (int i = startX; i >= 0; i--) {
            if (visited[i][startY]) {
                return new Point(i + 1, startY);
            }
            this.visited[i][startY] = true;
            this.ans.add(matrix[i][startY]);
        }
        return new Point(1, startY);
    }
    
    private Point downMove(int startX, int startY) {
        for (int i = startX; i < matrix.length; i++) {
            if (visited[i][startY]) {
                return new Point(i - 1, startY);
            }
            this.visited[i][startY] = true;
            this.ans.add(matrix[i][startY]);
        }
        return new Point(matrix.length - 1, startY);
    }
}