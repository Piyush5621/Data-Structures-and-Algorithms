class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        for( int i = 0; i < s.length() ; i ++){
            char c = s.charAt(i);
            if( c == '('){
                if(!st.isEmpty()){
                    str.append(c);
                }
                st.add(c); 
            }
            else{
                st.pop();
                if(!st.isEmpty()){
                    str.append(c);
                }
            }
           
        }
            
        return str.toString();
    }
}