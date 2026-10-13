class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for( int i = 0; i < n; i++ ){
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        int mid = n/2;
        for( int i = 0 ; i < mid; i++){
            ans -= (nums[i] * nums[i]);
        }

        for( int i = mid; i < n; i++ ){
            ans += (nums[i] * nums[i]);
        }

        return ans;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna