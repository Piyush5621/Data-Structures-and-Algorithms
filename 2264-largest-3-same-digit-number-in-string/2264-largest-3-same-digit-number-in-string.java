class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        for( int i =0; i < num.length()-2; i++){
            
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                int n = num.charAt(i) -'0';
                if( n > max ){
                    max = n;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(max);
        ans.append(max);
        ans.append(max);

        return (max == -1) ? "" : ans.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna