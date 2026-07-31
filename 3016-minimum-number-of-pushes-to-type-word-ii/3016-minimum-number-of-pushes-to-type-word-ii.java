class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int freq[] = new int[26];
        int distictChar = 0;

        for(int i=0; i < n ;i++){
            freq[word.charAt(i)-'a']++;
            if(freq[word.charAt(i)-'a']==1){
                distictChar++;
            }
        }

        int curr = 0;
        int ans = 0;
        int sum = 1;
        Arrays.sort(freq);
        for(int i = 25; i >=0; i--){
            if(curr%8==0 && curr!=0 ) sum++;
            if(freq[i]>0){
                ans += freq[i]*sum;
                curr++;
            }
        }
        return ans;


    }
}