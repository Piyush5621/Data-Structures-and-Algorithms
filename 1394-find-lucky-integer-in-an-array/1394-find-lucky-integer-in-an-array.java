class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 1;
        int ans = -1;
        for(int i = 1; i < n ; i++){
            if(arr[i]==arr[i-1]){
                count++;
            }
            else{
                if(count == arr[i-1]){
                    ans = arr[i-1];
                }
                count = 1;
            }
        }

        if(count == arr[n-1]){
            ans = count;
        }

        if(ans ==-1 && n==1 && arr[0]==1){
            return 1;
        } 

        return ans;
    }
}