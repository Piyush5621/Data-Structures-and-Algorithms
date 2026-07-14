class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder str = new StringBuilder();
        boolean onces = false;
        for(int i = 0 ; i < word.length(); i++ ){
            char c = word.charAt(i);
            str.append(c);
            if( c == ch && !onces){
                str.reverse();
                onces = true;
            }
        }
        return str.toString();
    }
}