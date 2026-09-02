class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int next = nums[0];
        while( true ){
            prev = nums[prev];
            next = nums[nums[next]];
            if( prev == next ) break;
        }
        prev = nums[0];
        while(prev !=  next ){
            prev = nums[prev];
            next = nums[next];
        }
        return prev;
    }
}