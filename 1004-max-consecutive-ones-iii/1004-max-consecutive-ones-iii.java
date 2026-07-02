class Solution {
    public int longestOnes(int[] nums, int k) {
        int currZero = 0;
        int n = nums.length;
        int left = 0;
        int ans = 0;
        for( int i = 0 ; i < n ; i++ ){
            if(nums[i]==0){
                currZero ++;
            }
            while(left <=i && currZero > k){
                if(nums[left]==0){
                    currZero--;
                }
                left++;
            }
            ans = Math.max( ans ,  i - left+1);
        }

        return  ans;


    }
}