class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int []suf = new int[n];
        suf[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            suf[i] = suf[i+1]+nums[i+1];
        }
        int ps = 0;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = Math.abs(ps-suf[i]);
            ps+=nums[i];
        }
        return ans;
    }

}