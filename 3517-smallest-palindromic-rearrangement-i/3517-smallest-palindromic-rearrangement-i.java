class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n==1) return s;
        int freq[] = new int[26];
        for(int i = 0 ; i < n ; i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder str = new StringBuilder();
        String middle = "";
        for(int i = 0 ; i < 26; i++){
            for(int j= 0; j < freq[i]/2;j++){
                str.append((char)(i+'a'));
            }  
            if(freq[i]%2==1){
                middle = String.valueOf((char) (i + 'a'));
            }
        }
        String first = str.toString();
        String reversed = new StringBuilder(str).reverse().toString();
        return first + middle + reversed;
    }
}