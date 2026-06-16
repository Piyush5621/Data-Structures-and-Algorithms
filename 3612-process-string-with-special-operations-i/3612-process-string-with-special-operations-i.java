class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='*' && !str.isEmpty()){
                str.setLength(str.length()-1);
            }
            else if(c =='#' && !str.isEmpty()){
                str.append(str.toString());
            }
            else if(c=='%'&& !str.isEmpty()){
                str.reverse();
            }
            else if(c>='a' && c<='z'){
                str.append(c);
            }
        }
        return str.toString();
    }
}