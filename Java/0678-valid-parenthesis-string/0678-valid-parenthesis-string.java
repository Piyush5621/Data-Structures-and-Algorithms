class Solution {
    public boolean checkValidString(String s) {
        int minBal = 0;
        int maxBal = 0;

        for( char c : s.toCharArray() ){
            if( c == '('){
                minBal++;
                maxBal++;
            }
            else if( c == ')' ){
                minBal--;
                maxBal--;
                if(maxBal < 0) return false;

            }
            else{
                minBal--;
                maxBal++;
            }
            if (minBal < 0) minBal=0;
        }

        return minBal==0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna