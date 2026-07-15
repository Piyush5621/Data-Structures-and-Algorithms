class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        for(int i =0 ; i<s.length(); i++){
            char c = s.charAt(i);
            if( c=='#'){
                if(!s1.isEmpty()) s1.pop();
            }
            else{
                s1.add(c);
            }
        }
        Stack<Character> s2 = new Stack<>();
        for(int i =0 ; i<t.length(); i++){
            char c = t.charAt(i);
            if(c=='#'){
                if(!s2.isEmpty()) s2.pop();  
            }
            else{
                s2.add(c);
            }
        }
        

        return s1.equals(s2);
    }
}