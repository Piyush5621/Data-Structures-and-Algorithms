class Solution {
    int rr[] = new int[]{-1,0,1,0};
    int cc[] = new int[]{0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==word.charAt(0)){
                    if(find(i,j,board,word,visited,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean find(int r, int c, char[][] board, String word, boolean[][] visited, int idx){
        if( r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] || board[r][c]!=word.charAt(idx) ||idx>=word.length() ){
            return false;
        }
        visited[r][c] = true;
        if(idx == word.length()-1){
            return true;
        }
        boolean res = false;
        for(int i=0; i<4; i++){
            int nr = r + rr[i];
            int nc = c+ cc[i];
            res |= find(nr,nc, board, word, visited, idx+1);
        }

        visited[r][c] = false;

        return res;
    }
}

// 2nd Solution using temp as StringBuilder

// class Solution {
//     int rr[] = new int[]{-1,0,1,0};
//     int cc[] = new int[]{0,1,0,-1};
//     public boolean exist(char[][] board, String word) {
//         int n = board.length;
//         int m = board[0].length;
//         boolean visited[][] = new boolean[n][m];

//         for(int i=0; i<n; i++){
//             for(int j=0; j<m; j++){
//                 if(board[i][j]==word.charAt(0)){
//                     StringBuilder temp = new StringBuilder();
//                     if(find(i,j,board,word,visited,temp)){
//                         return true;
//                     }
//                 }
//             }
//         }

//         return false;
//     }

//     boolean find(int r, int c, char[][] board, String word, boolean[][] visited, StringBuilder temp){
//         if( r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] || temp.length() > word.length()){
//             return false;
//         }
//         visited[r][c] = true;
//         temp.append(board[r][c]);
//         if(temp.toString().equals(word)){
//             return true;
//         }
//         boolean res = false;
//         for(int i=0; i<4; i++){
//             int nr = r + rr[i];
//             int nc = c+ cc[i];
//             res |= find(nr,nc, board, word, visited, temp);
//         }

//         visited[r][c] = false;
//         temp.delete(temp.length()-1, temp.length()); 

//         return res;
//     }
// }

