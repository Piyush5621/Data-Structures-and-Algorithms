class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int currInc = 1;
        int currDec = 1;
        int maxLen = 1;
        for( int i = 1; i < n; i++ ){
            if(nums[i] > nums[i-1] ){
                currInc++;
                currDec = 1;
            }
            else if(nums[i] < nums[i-1]){
                currDec++;
                currInc = 1;
            }
            else{
                currInc = 1;
                currDec = 1;
            }
            maxLen = Math.max(maxLen , Math.max(currInc,currDec));
        }

        return maxLen;


    }
}