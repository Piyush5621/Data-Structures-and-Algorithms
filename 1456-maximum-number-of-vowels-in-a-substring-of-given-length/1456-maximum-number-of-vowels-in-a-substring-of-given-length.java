class Solution {
    public int maxVowels(String s, int k) {
        String str = "aeiou";
        int vowelCount = 0;
        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))){
                vowelCount++;
            }
        }
        int ans = vowelCount;
        for(int i=k; i < s.length(); i++){
            char left = s.charAt(i-k);
            char right = s.charAt(i);

            if(isVowel(left)){
                vowelCount--;
            }
            if(isVowel(right)){
                vowelCount++;
            }
            ans = Math.max(ans, vowelCount);
        }
        return ans;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}