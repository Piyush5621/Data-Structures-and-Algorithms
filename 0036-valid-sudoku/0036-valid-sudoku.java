class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for( int i = 0; i < board.length; i++ ){
            for( int j = 0; j <board[0].length; j++){
                if(board[i][j]!='.'){
                    if(!isSafe(i,j,board,board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isSafe(int r ,int c , char[][] board, char num){
        for( int i = 0; i < board[0].length ; i++ ){
            if( board[r][i] == num && i != c ) return false;
        }
        for( int i = 0; i < board.length ; i++ ){
            if( board[i][c] == num && i != r ) return false;
        }
        int rowStart = r - (r % 3);
        int colStart = c - (c % 3);

        for( int i = rowStart; i < rowStart+ 3; i++){
            for( int j = colStart; j < colStart + 3; j++ ){
                if(board[i][j]==num && (i != r && j != c)) return false;
            }
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna