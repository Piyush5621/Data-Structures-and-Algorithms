class Solution {
    public int compareBitonicSums(int[] nums) {
        long sum1=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                sum1+=nums[i];
            }
        }
        long sum2=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1] < nums[i]){
                sum2+=nums[i];
            }
        }
        if(sum1>sum2){
            return 0;
        }
        else if(sum1<sum2){
            return 1;
        }
        return -1;
    }
}