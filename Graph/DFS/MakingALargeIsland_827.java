class Solution {
    static int rr[]=new int[]{-1,0,1,0};
    static int cc[]=new int[]{0,1,0,-1};
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int c=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int x=dfs(grid,i,j,c);
                    map.put(c,x);
                    c++;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    int size=1;
                    HashSet<Integer>set=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int nr=i+rr[k];
                        int nc=j+cc[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]>1){
                            if(!set.contains(grid[nr][nc])){
                                size+=map.get(grid[nr][nc]);
                                set.add(grid[nr][nc]);
                            }
                        }
                        
                    }
                    ans=Math.max(ans,size);
                }
                
            }
        }
        return (ans==0) ? m*n: ans;
    }
    static int dfs(int grid[][],int r,int c,int id){
        if(r<0 || r>=grid.length|| c<0 || c>=grid[0].length ||grid[r][c] != 1){
            return 0;
        }
        grid[r][c]=id;
        return 1+dfs(grid,r+1,c,id)+dfs(grid,r-1,c,id)+dfs(grid,r,c+1,id)+dfs(grid,r,c-1,id);
    }
}