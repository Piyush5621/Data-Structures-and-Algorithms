class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        int i=0;
        int j =1;
        int k =0;
        while( k < n){
            if(nums[k]%2==0){
                ans[i] = nums[k];
                i+=2;
            }else{
                ans[j] = nums[k];
                j+=2;
            }
            k++;
        }
        return ans;
    }
}