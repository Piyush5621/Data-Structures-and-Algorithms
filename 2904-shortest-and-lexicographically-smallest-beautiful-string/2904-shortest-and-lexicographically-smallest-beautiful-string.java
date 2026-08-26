class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int n = s.length();
        String ans ="";
        int countOne = 0;
        for( int i = 0; i < n ; i++){
            if(s.charAt(i) == '1'){
                countOne++;
            }
            while(countOne > k){
                char ch = s.charAt(left);
                if(ch == '1'){
                    countOne--;
                }
                left++;
            }
            if(countOne == k){
                while (s.charAt(left) == '0') {
                    left++;
                }
                String temp = s.substring(left,i+1);
                if(ans.equals("")|| temp.length() < ans.length() || temp.length()==ans.length() && temp.compareTo(ans) < 0){
                    ans = temp;
                }
            }            
        }
        return ans;
    }
}