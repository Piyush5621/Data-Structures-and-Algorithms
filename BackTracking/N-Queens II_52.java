class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char []arr : board) Arrays.fill(arr,'.');
        return solve(board,0);
    }

    int solve(char[][] board,int row){
        if(row==board.length){
            return 1;
        }

        int ans = 0;
        for(int i=0; i<board.length; i++){
            if(isSafe(row,i,board)){
                board[row][i]='Q';
                ans += solve(board,row+1);
                board[row][i]='.';
            }
        }
        return ans;
    }

    boolean isSafe(int r, int c, char[][]board){

        for(int i=0; i<r; i++){
            if(board[i][c]=='Q') return false;
        }

        int maxml = Math.min(r,c);
        for(int i=1; i<=maxml; i++){
            if(board[r-i][c-i]=='Q') return false;
        }

        int maxmr = Math.min(r,board.length-c-1);
        for(int i=1; i<=maxmr; i++){
            if(board[r-i][c+i]=='Q') return false;
        }
        return true;
        
    }

}