class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int ans = 0;
        int freq[] = new int[26];

        for(int i =0; i<n ; i++){
            freq[s.charAt(i) -'a']++;
            while(i-left>=2 && freq[0]>=1 && freq[1]>=1 && freq[2]>=1){
                ans+=(n-i);
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }

        return ans;
    }
}