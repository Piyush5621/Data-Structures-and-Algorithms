class Solution {
    public boolean validPalindrome(String s) {
        int c = 0;
        int low = 0;
        int high = s.length()-1;
        int n = s.length();

        while(low <= high){
            if(s.charAt(low)!=s.charAt(high)){
                String a = s.substring(low+1,high+1);
                String b = s.substring(low,high); 
                return isPallindrome(low+1,high,s) || isPallindrome(low,high-1,s);
            } 
            low++;
            high--;
        }
        return true;
    }

    private boolean isPallindrome(int l, int h,String s){
        while( l < h){
            if(s.charAt(l)!=s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}