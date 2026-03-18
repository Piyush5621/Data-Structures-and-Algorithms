class Triple{
    int a;
    int b;
    int d;
    Triple(int a,int b,int d){
        this.a=a;
        this.b=b;
        this.d=d;
    }
}
class Solution {
    int rr[]=new int[]{-1,0,1,0};
    int cc[]=new int[]{0,1,0,-1};
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean e=false;
        Queue<Triple>q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid,q);
                    e=true;
                    break;
                }
            }
            if(e){
                break;
            }
        }
        return bfs(grid,q);
    }

    void dfs(int r,int c,int [][]grid,Queue<Triple>q){
        if(r<0 || r>=grid.length|| c<0 || c>=grid[0].length || grid[r][c]==0 || grid[r][c]==2){
            return;
        }
        grid[r][c]=2;
        q.add(new Triple(r,c,0));
        dfs(r+1,c,grid,q);
        dfs(r-1,c,grid,q);
        dfs(r,c+1,grid,q);
        dfs(r,c-1,grid,q);
    }

    int bfs(int grid[][],Queue<Triple> q){
        while(!q.isEmpty()){
            Triple t=q.poll();
            int or=t.a;
            int oc=t.b;
            int od=t.d;
            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length){
                    if(grid[nr][nc]==1){
                        return od;
                    }
                    if(grid[nr][nc]==0){
                        grid[nr][nc]=2;
                        q.add(new Triple(nr,nc,od+1));
                    }
                }
            }
        }
        return -1;
    }
}