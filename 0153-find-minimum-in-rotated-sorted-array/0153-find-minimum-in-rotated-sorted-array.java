class Solution {
    public int findMin(int[] nums) {
        int start  = 0 ;
        int last = nums.length-1;
        while(start < last){
            int mid = start + (last-start)/2;

            if(nums[mid]< nums[last]){
                last = mid;
            }
            else{
                start = mid+1;
            }
        }
        return nums[start];
    }
}