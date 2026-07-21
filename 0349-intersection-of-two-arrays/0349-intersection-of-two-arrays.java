class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int freq[] = new int[1001];

        for(int x : nums1){
            if(freq[x]==0){
                freq[x]++;
            }
        }
        int len =0;
        for(int x : nums2){
            if(freq[x]==1){
                freq[x]++;
                len++;
            }
        }

        int ans[] = new int[len];
        int j = 0;
        for(int i = 0; i < 1001; i++){
            if(freq[i]==2){
                ans[j++] = i;
            }
        }
        return ans;
    }
}