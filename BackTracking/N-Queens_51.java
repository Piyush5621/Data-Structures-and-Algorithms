class Solution {
    public List<List<String>> solveNQueens(int n) {
        String [][]board=new String[n][n];
        for(String[]s:board){
            Arrays.fill(s,".");
        }
        return helper(board,0);
    }

    static List<List<String>> helper(String[][] board,int row){
        List<List<String>> ans=new ArrayList<>();
        if(row==board.length){
            List<String> list=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder str=new StringBuilder();
                for(int j=0;j<board.length;j++){
                    str.append(board[i][j]);
                }
                list.add(str.toString());
            }
            ans.add(list);
            return ans;
        }
        for(int col=0;col<board.length;col++){
            if(safe(board,row,col)){
                board[row][col]="Q";
                ans.addAll(helper(board,row+1));
                board[row][col]=".";
            }
        }

        return ans;
    }

    static boolean safe(String [][]board,int r,int c){
        for(int i=0;i<r;i++){
            if(board[i][c].equals("Q")){
                return false;
            }
        }

        int maxl=Math.min(r,c);
        for(int i=1;i<=maxl;i++){
            if(board[r-i][c-i].equals("Q")){
                return false;
            }
        }

        int maxr=Math.min(r,board.length-c-1);

        for(int i=1;i<=maxr;i++){
            if(board[r-i][c+i].equals("Q")){
                return false;
            }

        }

        return true;
    }

}