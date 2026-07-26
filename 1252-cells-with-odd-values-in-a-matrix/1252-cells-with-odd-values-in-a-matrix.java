class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int rr[] = new int[m];
        int cc[] = new int[n];

        for(int arr[] :  indices){
            if(arr[0]>= m || arr[1]>=n ) return -1;
            rr[arr[0]]++;
            cc[arr[1]]++;
        }
        int ans = 0;
        for(int i=0; i< m ; i++){
            for(int j = 0; j<n;j++){
                if((rr[i]+cc[j])%2!=0){
                    ans++;
                }
            }
        }
        return ans;

        
    }
}