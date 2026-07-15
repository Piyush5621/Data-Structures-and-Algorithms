class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && Math.abs(st.peek() - c)==32){
                st.pop();
            }else{
                st.add(c);
            }
        }

        while(!st.isEmpty()){
            res.append(st.peek());
            st.pop();
        }
        return res.reverse().toString();
    }
}