class Solution {
    public int scoreOfString(String s) {
        int maxm = 0;

        for(int i=1; i < s.length() ; i++){
            maxm += Math.abs(s.charAt(i) - s.charAt(i-1));
        }
        return maxm;
    }
}