class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int freq[] = new int[101];
        int n =nums.length;
        int ans [] = new int[n];
        int smaller = 0;
        for(int x : nums) freq[x]++;

        for(int i=0; i<101; i++){
            int cf = freq[i];
            freq[i] = smaller;
            smaller+=cf;
        }

        for(int i=0; i<n; i++){
            ans[i] = freq[nums[i]];
        }
        return ans;
    }
}