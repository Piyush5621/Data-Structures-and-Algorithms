class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int top1 = 0, left1 = 0;
        int top2 = 0, left2 = 0;
        int right1 = m-1, bottom1 = n-1; 
        int right2 = m-1, bottom2 = n-1; 
        int ans [][] = new int[n][m];
        while(top1 <=bottom1 && left1<=right1){
            List<Integer> list = new ArrayList<>();
            int  idx = k;
            for(int i=left1; i<=right1; i++){
                list.add(grid[top1][i]);
            }
            top1++;

            for(int i=top1; i<=bottom1; i++){
                list.add(grid[i][right1]);
            }
            right1--;

            if(top1<=bottom1){
                for(int i=right1; i>=left1; i--){
                    list.add(grid[bottom1][i]);
                }
                bottom1--;
            }

            if(left1<=right1){
                for(int i=bottom1; i>=top1; i--){
                    list.add(grid[i][left1]);
                }
                left1++;
            }

            int size = list.size();

            for(int i=left2; i<=right2; i++){
                ans[top2][i]=list.get(idx%size);
                idx++;
            }
            top2++;

            for(int i=top2; i<=bottom2; i++){
                ans[i][right2]=list.get(idx%size);
                idx++;
            }
            right2--;

            if(top2<=bottom2){
                for(int i=right2; i>=left2; i--){
                    ans[bottom2][i]=list.get(idx%size);
                    idx++;
                }
                bottom2--;
            }

            if(left2<=right2){
                for(int i=bottom2; i>=top2; i--){
                    ans[i][left2]=list.get(idx%size);
                    idx++;
                }
                left2++;
            }
        }
        return ans;
    }
}