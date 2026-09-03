class Solution {
    public boolean uniformArray(int[] nums1) {
        int countEven =  0 ;
        int n = nums1.length;
        int minm = Integer.MAX_VALUE;
        for( int x : nums1 ){
            if( x % 2 == 0 ){
                countEven++;
            } 
            minm = Math.min(minm, x);

        }
        if( minm % 2 == 1){
            return true;
        }
        return countEven == n;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna