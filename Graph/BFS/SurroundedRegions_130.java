class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q=new ArrayDeque<>();
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0|| j==0 || i==n-1 || j==m-1) && board[i][j]=='O'){
                    board[i][j]='&';
                    q.add(new int[]{i,j});
                }
            }
        }
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        while(!q.isEmpty()){
            int arr[]=q.poll();
            int or=arr[0];
            int oc=arr[1];
            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                if(nr>=1 && nr<n-1 && nc>=1 && nc<m-1 && board[nr][nc]=='O'){
                    board[nr][nc]='&';
                    q.add(new int[]{nr,nc});
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='&'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}
