class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        int arr[] = new int[m*n];
        k = k % (m*n);

        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        rotate(0, arr.length - k - 1, arr);
        rotate(arr.length - k, arr.length - 1, arr);
        rotate(0, arr.length - 1, arr);


        idx = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(arr[idx++]);
            }
            res.add(row);
        }

        return res;
        
    }

    void rotate(int i , int j , int arr[]){
        while( i < j ){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}