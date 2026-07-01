class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double sum = 0;
        double ans =0;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }
        
        ans = sum/k;
        
        for(int i=k; i<nums.length; i++){
            sum = sum-nums[left] + nums[i];
            ans = Math.max(sum/k,ans);
            left++;
        }
        return ans;
    }
}