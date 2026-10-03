class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxm = 0;
        for( int i =0 ; i < s.length(); i++ ){
            char ch = s.charAt(i);
            if(ch =='('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()) st.push(i);
                maxm = Math.max(maxm, i - st.peek());
            }
        }
        return maxm;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna