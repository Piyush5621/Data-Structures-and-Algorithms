class Solution {
    public String firstPalindrome(String[] words) {
        for(String str : words ){
            if(isPallindrome(str)){
                return str;
            }
        }
        return "";
    }
    private boolean isPallindrome(String str){
        int i = 0;
        int n = str.length()-1;

        while(i < n){
            if(str.charAt(i)!=str.charAt(n)){
                return false;
            }
            i++;
            n--;
        }
        return true;
    }
}