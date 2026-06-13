class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for(String str : words){
            int curr =0;
            for(int i=0; i<str.length(); i++){
                curr += weights[str.charAt(i)-'a'];
            }
            curr = curr%26;
            char c = (char)('a'+(26-curr-1));
            ans.append(c);
        }

        return ans.toString();
    }
}