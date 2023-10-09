import java.awt.Point;

class Solution {
    
    public void setZeroes(int[][] matrix) {
        List<Point> zeroList = makeZeroList(matrix);
        for (Point curPoint : zeroList) {
            makeZero(curPoint, matrix);
        }
    }
    
    private List<Point> makeZeroList(int[][] matrix){
        List<Point> zeroList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    zeroList.add(new Point(i, j));
            }
        }
        return zeroList;
    }
    
    private void makeZero(Point point, int[][] matrix) {
        for (int i = 0; i< matrix.length; i++) {
            matrix[i][point.y] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[point.x][i] = 0;
        }
    }
}