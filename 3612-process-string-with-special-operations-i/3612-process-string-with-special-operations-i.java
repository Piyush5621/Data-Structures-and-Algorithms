class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()){
            switch(c){
                case '*':
                    if(str.length()>0){
                        str.setLength(str.length()-1);
                    }
                    break;
                case '#':
                    if(str.length()>0){
                        str.append(str);
                    }
                    break;
                case '%':
                    if(str.length()>0){
                        str.reverse();
                    }
                    break;
                default :
                    if(c>='a' && c<='z'){
                        str.append(c);
                    }
            }
        }
        return str.toString();
    }
}