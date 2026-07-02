class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int x : nums) totalSum+=x;
        int n = nums.length;
        int prefixSum = 0;
        int ps =0;
        for(int i=0; i<n; i++){
            ps +=nums[i];
            if(prefixSum == totalSum - ps){
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }
}