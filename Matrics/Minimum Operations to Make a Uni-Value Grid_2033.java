class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int arr[] = new int[n*m];
        int k=0;
        int curr = grid[0][0]%x;
        for(int i=0; i<n; i++ ){
            for(int j=0; j<m; j++){
                if(grid[i][j]%x!=curr){
                    return -1;
                }
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int t = arr[arr.length/2];
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            int y = Math.abs(arr[i]-t)/x;
            ans+=y;
        }
        return ans;
    }
}