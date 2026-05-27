class Solution {
    public int numberOfSpecialChars(String word) {
        int freq[] = new int[52];
        int cnt = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z'){
                freq[(ch-'a')+26]++;
            }else{
                freq[ch-'A']++;
            }
        }
        int freq2[] = new int[52];
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z'){
                freq2[ch-'a']++;
            }
            else{
                char chh = Character.toLowerCase(ch);
                if(freq[(chh-'a')+26]>0 && freq2[chh-'a']==freq[(chh-'a')+26] && freq2[(chh-'a')+26]==0){
                    set.add(chh);
                }
                freq2[(chh-'a')+26]++;
            }
        }
        return set.size();
    }
}