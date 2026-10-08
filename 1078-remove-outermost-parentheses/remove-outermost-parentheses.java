class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int bal = 0;
        for( int i = 0; i < s.length(); i++ ){
            if(s.charAt(i)=='('){
                if(bal > 0) str.append('(');
                bal++;
            }
            else{
                bal--;
                if(bal > 0){
                    str.append(')');
                }
            }
        }
        return str.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna