class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n=grid.length;
        int m=grid[0].length;
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        Queue<int[]>q=new ArrayDeque();
        boolean vist[][]=new boolean[n][m];
        q.add(new int[]{row,col});
        int x=grid[row][col];    
        vist[row][col]=true;
        List<int[]>list=new ArrayList<>();
        while(!q.isEmpty()){
            int arr[]=q.poll();
            int or=arr[0];
            int oc=arr[1];
            boolean present =false;
            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                if(nr<0 || nr>=n ||  nc<0 || nc>=m){
                   present=true;
                }
                else if(grid[nr][nc]!=x){
                    present=true;
                }
                else if(!vist[nr][nc] && grid[nr][nc]==x){
                    vist[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
            if(present){
                list.add(new int[]{or,oc});
            }
        }
        for(int a[]: list){
            grid[a[0]][a[1]]=color;
        }

        
        return grid;
    }
}