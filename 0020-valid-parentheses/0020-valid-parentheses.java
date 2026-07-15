class Solution {
    public boolean isValid(String str) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char x=str.charAt(i);
            if(x=='('||x=='{'||x=='['){
                s.push(x);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                else{
                    char a=s.peek();
                    if(!(a=='('&& x==')'|| a=='{'&&x=='}'|| a=='['&& x==']' )){
                       return false;
                    }
                    else{
                        s.pop();
                    }
                }
            }
        }
        return s.empty();
    }
}