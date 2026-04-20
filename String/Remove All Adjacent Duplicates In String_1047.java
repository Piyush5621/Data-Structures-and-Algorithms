class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0 ; i < s.length(); i++){
            char a = s.charAt(i);
            if(st.isEmpty()){
                st.add(a);
            }
            else{
                if(st.peek()==a){
                    st.pop();
                }
                else{
                    st.add(a);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) str.append(st.pop());
        return str.reverse().toString();
    }
}

//2nd solution 
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(str.length()==0){
                str.append(a);
            }
            else{
                if(str.charAt(str.length()-1)==a){
                    str.deleteCharAt(str.length()-1);
                }
                else{
                    str.append(a);
                }
            }
        }
        return str.toString();
    }
}

//3rd 
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(str.length()==0){
                str.append(a);
            }
            else{
                if(str.charAt(str.length()-1)==a){
                    str.setLength(str.length()-1);
                }
                else{
                    str.append(a);
                }
            }
        }
        return str.toString();
    }
}