class Solution {
    public int minPairSum(int[] nums) {
        int maxm = Integer.MIN_VALUE;
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length-1;

        while( i < j ){
            int sum = nums[i] + nums[j];
            maxm =  Math.max(sum, maxm);
            i++;
            j--; 
        }
        return maxm;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna