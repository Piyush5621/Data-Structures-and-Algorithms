class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }
                else{
                    st.add(c);
                }
            }
            else{
                st.add(c);
            } 
        }
        return st.size();
    }
}