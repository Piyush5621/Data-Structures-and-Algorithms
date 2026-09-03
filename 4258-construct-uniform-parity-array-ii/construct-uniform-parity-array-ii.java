class Solution {
    public boolean uniformArray(int[] nums1) {
        int countEven =  0 ;
        int countOdd = 0;
        int n = nums1.length;
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        for( int x : nums1 ){
            if( x % 2 == 0 ){
                countEven++;
                minEven = Math.min(minEven , x);
            }
            else{
                countOdd++;
                minOdd = Math.min(minOdd, x);
            } 
        }   
        if( countEven == n || countOdd == n) return true;
        return minEven > minOdd;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna