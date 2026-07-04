class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = 1000000007;
        int low = 0;
        int high = nums.length-1;
        int ans = 0;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        while(low <= high){
            if(nums[low]+nums[high] <= target){
                int x = high-low;
                ans= (ans+(pow[x])) % mod;
                low++;
            }
            else{
                high--;
            }
        }

        return ans;
    }
}