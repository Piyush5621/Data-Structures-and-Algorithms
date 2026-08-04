class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int freq[] = new int[101];
        int maxm = 0;
        int minm = 101;
        for(int x : nums) {
            freq[x]++;
            maxm = Math.max(maxm,x);
            minm = Math.min(minm,x);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=minm; i <= maxm ; i++){
            if(freq[i]==0) ans.add(i);
        }
        return ans;
    }
}