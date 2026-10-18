class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        int rr[] = new int[]{0,0,-1,1};
        int cc[] = new int[]{-1,1,0,0};
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        q.offer(new int[]{0,0});
        int row =-1;
        int col = -1;
        while(!q.isEmpty()){
            int arr[] = q.poll();
            row = arr[0];
            col = arr[1];
            vis[row][col] = true;
            if(grid[arr[0]][arr[1]] == 'L' && arr[1]-1 >=0 && !vis[arr[0]][arr[1]-1]){
                q.offer(new int[]{arr[0],arr[1]-1});
            }
            else if(grid[arr[0]][arr[1]] == 'R' && arr[1]+1 < grid[0].length && !vis[arr[0]][arr[1]+1] ){
                q.offer(new int[]{arr[0],arr[1]+1});
            }
            else if(grid[arr[0]][arr[1]] == 'D' && arr[0]+1 < grid.length && !vis[arr[0]+1][arr[1]] ){
                q.offer(new int[]{arr[0]+1,arr[1]});
            }
            else if(grid[arr[0]][arr[1]] == 'U' && arr[0]-1 >=0 && !vis[arr[0]-1][arr[1]] ){
                q.offer(new int[]{arr[0]-1,arr[1]});
            }
        }
        return new int[]{row,col};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna