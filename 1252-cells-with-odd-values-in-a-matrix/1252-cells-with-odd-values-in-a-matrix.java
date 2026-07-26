class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int rr[] = new int[m];
        int cc[] = new int[n];

        for(int arr[] :  indices){
            rr[arr[0]]++;
            cc[arr[1]]++;
        }
        int oddRow = 0;
        int oddCol = 0;
        for(int i = 0; i < m ; i++){
            if(rr[i]%2!=0) oddRow++;
        }
        for(int i = 0; i <n ;i++){
            if(cc[i]%2!=0) oddCol++;
        }

        int evenRow = m-oddRow;
        int evenCol = n-oddCol;
        return (oddRow * evenCol) + (evenRow * oddCol);

        
    }
}