class Solution {
    public int maximumDifference(int[] nums) {
        int minm = nums[0];
        int n = nums.length;
        int ans = -1;
        for(int i = 1 ; i < n ; i++){
            if(minm > nums[i]){
                minm = nums[i];
                continue;
            }
            ans = Math.max(ans, nums[i] - minm);
            
        }

        return ans==0 ? -1 : ans;
    }
}