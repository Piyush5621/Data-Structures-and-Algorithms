class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int prefixMax[] = new int[n];
        int suffixMax[] = new int[n];

        prefixMax[0] = nums[0];
        int sum = nums[0];
        for(int i=1;i<n;i++){
            sum+=nums[i];
            prefixMax[i] = Math.max(sum,prefixMax[i-1]);
        } 
        
        sum = nums[n-1];
        suffixMax[n-1]= nums[n-1];
        for(int i=n-2;i>=0;i--){
            sum+=nums[i];
            suffixMax[i] = Math.max(sum,suffixMax[i+1]);
        } 

        int maxm = Integer.MIN_VALUE;
        int curr = 0;

        for (int x : nums) {
            curr = Math.max(x, curr + x);
            maxm = Math.max(maxm, curr);
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i =0;i<n-1; i++){
            ans = Math.max(ans, prefixMax[i]+suffixMax[i+1]);
        }

        return Math.max(ans,maxm);
    }
}