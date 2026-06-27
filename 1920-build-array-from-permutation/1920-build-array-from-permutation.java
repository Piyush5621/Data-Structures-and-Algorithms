class Solution {
    public int[] buildArray(int[] nums) {
        permute(nums,0);
        return nums;
    }

    public void permute(int nums[], int start){
        if(start>=nums.length) return;
        int temp = nums[nums[start]];
        permute(nums,start+1);
        nums[start]= temp;
    }
}