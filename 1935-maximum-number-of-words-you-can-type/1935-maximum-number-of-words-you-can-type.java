class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean type = true;
        boolean broken[] = new boolean[26];
        int ans = 0;

        for(int i=0; i<brokenLetters.length(); i++){
            broken[brokenLetters.charAt(i)-'a'] = true;
        }
        for(int i = 0; i< text.length(); i++){
            char c = text.charAt(i);
            if( c ==' '){
                if(type) ans++;
                type = true;
            }
            else if(broken[c-'a']){
                type = false;
            }
        }
        if(type) ans++;
        return ans;
    }
}