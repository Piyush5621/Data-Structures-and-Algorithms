class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                ans=i+1;
            }
            else{
                continue;
            }
        }

        return ans;
    }
}