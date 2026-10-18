class Solution {
    public int minDeletions(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for( int i=1; i < n; i++ ){
            if(nums[i] == nums[i-1] ) ans++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna