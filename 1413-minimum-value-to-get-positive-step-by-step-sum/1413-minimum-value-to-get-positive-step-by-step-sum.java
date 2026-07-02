class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length; 
        int prefixSum = 0;
        int minmVal = Integer.MAX_VALUE;
        for( int i = 0 ; i < n ; i++ ){
            prefixSum += nums[i];
            minmVal = Math.min(minmVal,prefixSum);
        }

        return (minmVal < 0)? Math.abs(minmVal)+1 : 1;
    }
}