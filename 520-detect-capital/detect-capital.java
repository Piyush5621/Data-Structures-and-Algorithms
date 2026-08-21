class Solution {
    public boolean detectCapitalUse(String word) {
        int lowerCount = 0;
        int n = word.length();
        for( int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if( ch >= 'a' && ch <='z'){
                lowerCount++;
            }
        }
        return lowerCount == 0 || lowerCount == n || (lowerCount == n-1 &&  word.charAt(0)>='A'&& word.charAt(0) <= 'Z');
    }
}