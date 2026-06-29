class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int res [] = new int[n];

        int start =0;
        int end =n-1;
        int last = n-1;
        while(start <= end){
            if(Math.abs(nums[start]) < Math.abs(nums[end])){
                res[last] = nums[end] * nums[end];
                end--;
            }
            else{
                res[last] = nums[start] * nums[start];
                start++;
            }
            last--;
        }
        return res;

        
    }
}