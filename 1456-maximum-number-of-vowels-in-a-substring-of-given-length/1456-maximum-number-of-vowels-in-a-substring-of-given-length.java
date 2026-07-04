class Solution {
    public int maxVowels(String s, int k) {
        String str = "aeiou";
        int vowelCount = 0;
        for(int i = 0; i < k; i++){
            if(str.indexOf(s.charAt(i))!=-1){
                vowelCount++;
            }
        }
        int ans = vowelCount;
        for(int i=k; i < s.length(); i++){
            char left = s.charAt(i-k);
            char right = s.charAt(i);

            if(str.indexOf(left)!=-1){
                vowelCount--;
            }
            if(str.indexOf(right)!=-1){
                vowelCount++;
            }
            ans = Math.max(ans, vowelCount);
        }
        return ans;
    }
}