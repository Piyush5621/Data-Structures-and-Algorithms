class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> st = new Stack<>();
        String []str = path.split("/");

        for( String s : str ){
            if(s.equals("") || s.equals(".")){
                continue;
            }
            else if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(s);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0,st.pop());
            ans.insert(0,"/");
            
        }

        return (ans.length()==0)? "/" :ans.toString();
    }
}