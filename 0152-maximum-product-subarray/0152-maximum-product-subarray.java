class Solution {
    public int maxProduct(int[] nums) {
        int minPro = nums[0];
        int maxPro = nums[0];
        int ans  = nums[0];
        for( int i = 1 ; i < nums.length; i++ ){
            int curr = nums[i];

            if(curr <  0){
                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }

            minPro = Math.min( curr , curr * minPro);
            maxPro = Math.max(curr , curr * maxPro);

            ans = Math.max(maxPro, ans);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna