class Solution {
    public int minMoves(int[] nums) {
        int maxm = nums[0];
        int sum = 0;
        for( int x : nums ){
            maxm = Math.max(maxm, x);
            sum += x;
        }

        return maxm * nums.length - sum;

    }
}