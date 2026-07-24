class Solution {
    public int uniqueXorTriplets(int[] nums) {
       int maxm = 2049;
       boolean [] pair = new boolean[maxm];
       boolean [] ans = new boolean[maxm];
        int n = nums.length;
       for(int i = 0; i < n ; i++){
            for(int j = i; j < n ; j++){
                int duo = (nums[i]^nums[j]); 
                pair[duo] = true;
            }
       }
       for(int i = 0; i < maxm; i++){
            if(pair[i]){
                for(int j = 0; j < n ; j++ ){
                    int tri = nums[j] ^ i;
                    ans[tri] = true;
                }
            }
            
       }
        int count = 0;
        for(int i = 0; i < maxm; i++){
            if(ans[i]==true) count++;
        }
       
       return count;
    }
}