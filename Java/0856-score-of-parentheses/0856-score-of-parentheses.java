class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for( int i = 0 ; i < s.length(); i++ ){
            if(s.charAt(i) == '('){
                st.push(0);
            }
            else{
                int top = st.pop();
                if(top == 0){
                    top++;
                }
                else{
                    top = 2*top;
                }
                st.push(st.pop() + top );
            }
        }
        return st.peek();  
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna