class Solution {
    public int minMergedInteger(int[] nums) {
        int minm = Integer.MAX_VALUE;
        for( int i =1; i < nums.length ; i+=2 ){
            StringBuilder str = new StringBuilder();
            str.append(nums[i-1]);
            str.append(nums[i]);
            int curr = Integer.parseInt(str.toString());
            minm = Math.min(minm, curr);
        }
        return minm;
    }
}