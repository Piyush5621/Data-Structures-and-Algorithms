class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean type = true;
        int ans = 0;
        for(int i = 0; i< text.length(); i++){
            if(brokenLetters.indexOf(text.charAt(i))!=-1){
                type = false;
            }

            if(text.charAt(i)==' '){
                if(type){
                    ans++;
                } 
                type = true;
            }
        }
        if(type) ans++;
        return ans;
    }
}