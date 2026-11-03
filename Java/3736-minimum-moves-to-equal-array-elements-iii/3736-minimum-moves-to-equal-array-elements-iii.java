class Solution {
    public int minMoves(int[] nums) {
        int maxm = nums[0];

        for( int x : nums ){
            maxm = Math.max(maxm, x);
        }
        int ans = 0;
        for( int x : nums ){
            ans += (maxm - x);
        }

        return ans;

    }
}