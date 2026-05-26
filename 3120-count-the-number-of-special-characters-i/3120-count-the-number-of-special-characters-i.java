class Solution {
    public int numberOfSpecialChars(String word) {
        int freq[] = new int[52];
        int count =0;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z'){
                freq[ch-'a']++;
            }
            else if(ch>='A' && ch<='Z'){
                freq[(ch-'A')+26]++;
            }
        }
        for(int i=0; i<26; i++){
            if(freq[i]>0 && freq[i+26]>0){
                count++;
            }
        }
        return count;
    }
}