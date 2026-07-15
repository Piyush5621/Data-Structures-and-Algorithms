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