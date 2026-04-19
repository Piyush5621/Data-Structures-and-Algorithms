class Solution {
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(str.length()!=0 && a == '*') str.deleteCharAt(str.length()-1);
            else str.append(a);
        }
        return str.toString();
    }
}