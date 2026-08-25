class Solution {
    public String reverseByType(String s) {

        StringBuilder str = new StringBuilder(s);
        String spclChar ="";
        String Chars ="";
        for( int i = 0; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                Chars+=ch;
            }
            else{
                spclChar+=ch;
            }
        }
        int j = Chars.length()-1;
        int k = spclChar.length()-1;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                str.setCharAt(i,Chars.charAt(j));
                j--;
            }
            else{
                str.setCharAt(i,spclChar.charAt(k));
                k--;
            }
        }
        return str.toString();

    }
}