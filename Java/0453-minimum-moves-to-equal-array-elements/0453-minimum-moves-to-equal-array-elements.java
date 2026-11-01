class Solution {
    public int minMoves(int[] nums) {
        int ans = 0;
        int minm = Integer.MAX_VALUE;
        for( int x : nums ){
            minm = Math.min(minm, x);
        }

        for( int x : nums ){
           ans += (x-minm);
        }


        return ans;
    }
}