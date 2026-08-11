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
                String revA = new StringBuilder(a).reverse().toString();
                String revB = new StringBuilder(b).reverse().toString();
                return revA.equals(a)|| revB.equals(b);
            } 
            low++;
            high--;
        }
        return true;
    }
}