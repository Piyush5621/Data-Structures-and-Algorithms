class Solution {
    public boolean check(int a[],int b[],int op[],int i){
        for(int d : a){
            if(d==i){
                for(int nd : b){
                    if(nd == op[d]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int street[][] = new int[][]{
            {},
            {3,1},
            {0,2},
            {3,2},
            {1,2},
            {3,0},
            {1,0}
        };
        int opposite[]=new int[]{2,3,0,1};
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        Queue<int[]> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][m];
        q.add(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int or = curr[0];
            int oc = curr[1];
            if(or==n-1 && oc==m-1){
                return true;
            }
            for(int i=0; i<4; i++){
                int nr = or+rr[i];
                int nc = oc+cc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m && !visited[nr][nc]){
                    if(check(street[grid[or][oc]],street[grid[nr][nc]],opposite,i)){
                        q.add(new int[]{nr,nc});
                        visited[nr][nc] = true; 
                    }
                }
            }
        }
        return false;
    }
}