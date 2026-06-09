class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long minm =nums[0];
        long maxm = nums[0];

        for(int x : nums) {
            minm = Math.min(minm,x);
            maxm = Math.max(maxm,x);
        }

        return (maxm-minm)*k;
    }
}