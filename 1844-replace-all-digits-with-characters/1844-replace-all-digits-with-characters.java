class Solution {
    public String replaceDigits(String s) {
        StringBuilder str = new StringBuilder(s);
        char ch =' ';
        for( int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c -'0';
                str.setCharAt(i,(char)(ch+num));
            }
            else{
                ch = c;
            }
        }
        return str.toString();
    }
}