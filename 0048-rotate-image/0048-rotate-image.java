class Solution {
    private int[][] result;
    public void rotate(int[][] matrix) {
        result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            rotateByOneLine(matrix, i);
        }
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(result[i], 0, matrix[i], 0, matrix.length);   
        }
    }
    
    private void rotateByOneLine(int[][] matrix, int idx) {
        for (int i = 0; i < matrix[0].length; i++) {
            result[idx][i] = matrix[matrix.length - i - 1][idx];
        }
    }
}