class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int freq[] = new int[26];

        for(int i=0; i < n ;i++) freq[word.charAt(i)-'a']++;

        int curr = 0;
        int ans = 0;
        int sum = 1;
        countSort(freq);
        for(int i = 25; i >=0; i--){
            if(curr%8==0 && curr!=0 ) sum++;
            if(freq[i]>0){
                ans += freq[i]*sum;
                curr++;
            }
        }
        return ans;
    }
    public void countSort(int[] nums){
       int max=0;
        for(int i=0;i<26;i++){
            max=Math.max(nums[i],max);
        }
        int freq[]=new int[max+1];
        for(int i=0;i<26;i++){
            freq[nums[i]]++;
        }
        int j=0;
        for(int i=0;i<max+1;i++){
            while(freq[i]>0){
                nums[j]=i;
                freq[i]--;
                j++;
            }
        }
    }
}