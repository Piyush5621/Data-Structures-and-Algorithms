class Solution {
    public int minSwaps(int[] nums) {
        int noo = 0 ;
        for(int i =0; i<nums.length; i++){
            if(nums[i]==1) noo++;
        }
        int n = nums.length;
        int ans = 1;
        int currZero =0;

        for(int i=0; i<noo; i++){
            if(nums[i]==0){
                currZero++;
            }
        }

        ans = currZero;
        int left = 0;
        for(int i=noo; i<nums.length+noo-1; i++){
            if(nums[left%n]==0){
                currZero--;
            }

            if(nums[i%n]==0){
                currZero++;
            }

            ans = Math.min(ans, currZero);
            left++;
        }
        return ans;
    }
}