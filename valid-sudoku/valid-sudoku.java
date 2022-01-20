class Solution {
    public boolean isValidSudoku(char[][] board) {
        LinkedHashSet<Character> hashSet = new LinkedHashSet<>();
        boolean checkRow = checkRow(board, hashSet);
        if (!checkRow){
            return false;
        }
        boolean checkCol = checkCol(board, hashSet);
        if (!checkCol){
            return false;
        }
        boolean checkSub = checkSub(board, hashSet);
        if (!checkSub){
            return false;
        }
        return true;
    }
    private static boolean checkRow(char[][] board, LinkedHashSet<Character> hashSet){
        hashSet.clear();
        for (int i = 0; i < 9; i++){
            hashSet.clear();
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    if (!hashSet.contains(board[i][j])){
                        hashSet.add(board[i][j]);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private static boolean checkCol(char[][] board, LinkedHashSet<Character> hashSet){
        hashSet.clear();
        for (int i = 0; i < 9; i++){
            hashSet.clear();
            for (int j = 0; j < 9; j++){
                if (board[j][i] != '.'){
                    if (!hashSet.contains(board[j][i])){
                        hashSet.add(board[j][i]);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private static boolean checkSub(char[][] board, LinkedHashSet<Character> hashSet){
        hashSet.clear();
        for (int i = 0; i < 9; i++){
            hashSet.clear();
            for (int j = i / 3 * 3; j < i / 3 * 3 + 3; j++){
                for (int k = i % 3 * 3; k < i % 3 * 3 + 3; k++){
                    if (board[j][k] != '.'){
                        if (!hashSet.contains(board[j][k])){
                            hashSet.add(board[j][k]);
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}