class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int open = 0;
        for( int i =0; i < s.length(); i++ ){
            if(s.charAt(i)=='('){
                open++;
            }
            else{
                open--;
                if(open < 0){
                    ans++;
                    open++;
                }
            }
        }
        return ans + open;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna