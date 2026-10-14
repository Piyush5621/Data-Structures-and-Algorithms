class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if( num*9 < sum ) return "";
        StringBuilder str = new StringBuilder();
        while( num > 0 ){
            int d = Math.min( 9, sum);
            str.append(d);
            sum -= d; 
            num--;
        }
        return str.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna