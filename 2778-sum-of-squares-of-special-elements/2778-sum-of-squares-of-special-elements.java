class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for( int i = 0; i < nums.length; i++ ){
            if( n % (i+1) == 0){
                sum += (nums[i] * nums[i]); 
            }
        }

        return sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna