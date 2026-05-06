class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][]board){
        int n = board.length;
        int m = board[0].length;
        int wr=-1;
        int wc=-1;
        boolean flag = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='.'){
                    wr = i;
                    wc = j;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        if(flag){
            for(char i='1';i<='9';i++){
                if(isSafe(i,wr,wc,board)){
                    board[wr][wc]=i;
                    if(solve(board)){
                        return true;
                    }
                    board[wr][wc]='.';
                }
            }
        }
        else{
            return true;
        }
        return false;
    }
    boolean isSafe(char n,int r,int c,char[][] board){
        for(int i=0;i<board.length;i++){
            if(board[i][c]==n) return false;
        }
        for(int i=0;i<board.length;i++){
            if(board[r][i]==n) return false;
        }

        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = r - r % sqrt ;
        int colStart = c - c % sqrt;

        for(int i=rowStart; i<rowStart+sqrt; i++){
            for(int j=colStart; j<colStart+sqrt; j++){
                if(board[i][j]==n){
                    return false;
                }
            }
        }
        return true;
    }
}