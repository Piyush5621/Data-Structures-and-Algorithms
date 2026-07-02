class Solution {
    class pair{
        int row;
        int col;
        int hlth;

        pair(int a,int b,int c){
            row = a;
            col = b;
            hlth = c;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        boolean visited[][] = new boolean[n][m];

        int rr[] = new int[]{-1,0,1,0};
        int cc[] = new int[]{0,1,0,-1};


        PriorityQueue<pair> q = new PriorityQueue<>((a,b)-> a.hlth - b.hlth);
        if(grid.get(0).get(0)==1){
            q.add(new pair(0,0,1));
        }else{
            q.add(new pair(0,0,0));
        }
        visited[0][0] = true;
        while(!q.isEmpty()){
            pair p = q.poll();

            int oldrow = p.row;
            int oldcol = p.col;
            int oldHealth = p.hlth;

            if(oldrow==n-1 && oldcol==m-1 ){
                return true;
            }

            for(int i = 0 ; i < 4; i++){
                int newRow = oldrow + rr[i];
                int newCol = oldcol + cc[i];

                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !visited[newRow][newCol]){
                    int newHealth = (grid.get(newRow).get(newCol)==1)? oldHealth+1: oldHealth;
                    if(newHealth < health){
                        q.add(new pair(newRow, newCol,newHealth));
                        visited[newRow][newCol]= true;
                    }
                }
            }

        }
        return false;
    }
}