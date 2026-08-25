class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int countOnes = 0;
        int countZero = 0;
        int left  = 0;
        int ans = 0;
        for( int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                countZero++;
            }
            else{
                countOnes++;
            }

            while(countOnes > k && countZero > k){
                char ch = s.charAt(left);
                if(ch == '0'){
                    countZero--;
                }
                else{
                    countOnes--;
                }
                left++;
            }

            ans += (i-left+1);

        }
        return ans;
    }
}