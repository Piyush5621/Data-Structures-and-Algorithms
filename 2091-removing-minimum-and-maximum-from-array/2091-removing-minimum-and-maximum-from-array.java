class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = 0;
        int maxIdx = 0;
        int n = nums.length; 
        int minm = Integer.MAX_VALUE;
        int maxm = Integer.MIN_VALUE;
        for( int i = 0; i < n ; i++ ){
            if(nums[i] < minm){
                minIdx = i;
                minm = nums[i];
            }
            if(nums[i] > maxm){
                maxIdx = i;
                maxm = nums[i];
            }
        }
        int moves1 = Math.max(minIdx,maxIdx)+1;
        int moves2 = n - Math.min(minIdx , maxIdx);
        int moves3 = Math.min(minIdx,maxIdx) + n - Math.max(minIdx,maxIdx) + 1 ;
        return Math.min(moves1,Math.min(moves2,moves3));
    }
}