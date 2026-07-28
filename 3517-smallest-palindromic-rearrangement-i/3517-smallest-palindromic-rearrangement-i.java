class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n==1) return s;
        int freq[] = new int[26];
        char[] str = new char[n];
        for(int i = 0 ; i < n ; i++){
            freq[s.charAt(i)-'a']++;
        }
        char middle = '\0';
        int k =0;
        int left =0;
        int right =n-1;
        for(int i = 0 ; i < 26; i++){
            while(freq[i] >= 2){
                str[left++] = (char)(i+'a');
                str[right--] = (char)(i+'a');
                freq[i] -=2; 
            } 
            if(freq[i]==1){
                middle = (char) (i + 'a');
            }
        }
        if(middle != '\0'){
            str[left] = middle;
        }
        return new String(str);
    }
}