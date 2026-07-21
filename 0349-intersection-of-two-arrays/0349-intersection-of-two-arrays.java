class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int freq[] = new int[1001];
        int ans[] = new int[Math.min(nums1.length, nums2.length)];

        for(int x : nums1){
            freq[x]++;
        }
        int j = 0;
        int c = 0;
        for(int x : nums2){
            if(freq[x]>=1){
                ans[j++] = x;
                c++;
                freq[x] = 0;
            }
        }
        int res[] = new int[c];
        for(int i = 0; i < c; i++){
            res[i] = ans[i];
        }

        return res;
    }
}