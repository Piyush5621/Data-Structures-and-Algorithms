class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int freq[] = new int[26];

        for(int i=0; i<allowed.length(); i++){
            freq[allowed.charAt(i)-'a']++;
        }
        int ans = 0;
        for(String str : words){
            boolean yes = true;
            for(int i=0; i<str.length();i++){
                if(freq[str.charAt(i)-'a']==0){
                    yes = false;
                    break;
                }
            }
            if(yes) ans++;
        }

        return ans;
    }
}