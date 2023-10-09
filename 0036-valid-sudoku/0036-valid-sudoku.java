class Solution {
    private char[][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < board[0].length; i++) {
            boolean isValid = checkCol(i) && checkRow(i) && checkSubSquare(i);
            System.out.println("i " + i + checkCol(i) + " " + checkRow(i) + " " + checkSubSquare(i));
            if (!isValid)
                return false;
        }
        return true;
    }
    
    private boolean checkCol(int idx) {
        boolean[] numCheck = new boolean[10];
        for (int i = 0; i < board[0].length; i++) {
            if (board[idx][i] == '.')
                continue;
            int val = board[idx][i] - '0';
            if (numCheck[val])
                return false;
            else numCheck[val] = true;
        }
        return true;
    }
    
    // check validation row
    private boolean checkRow(int idx) {
        boolean[] numCheck = new boolean[10];
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][idx] == '.')
                continue;
            int val = board[i][idx] - '0';
            if (numCheck[val])
                return false;
            else numCheck[val] = true;
        }
        return true;
    }
    
    // sub-square check
    private boolean checkSubSquare(int idx) {
        int start = idx / 3;
        int startJ = idx % 3;
        boolean[] numCheck = new boolean[10];
        for (int i = start * 3 ; i < start * 3 + 3; i++) {
            for (int j = startJ * 3 ; j < startJ * 3 + 3; j++) {
                System.out.println(" i" + i + " " + j);
                if (board[i][j] == '.')
                    continue;
                int val = board[i][j] - '0';
                if (numCheck[val])
                    return false;
                else numCheck[val] = true;
            }
        }
        return true;
    }
}