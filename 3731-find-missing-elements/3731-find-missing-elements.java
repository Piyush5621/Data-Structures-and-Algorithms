class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxm = 0;
        int minm = 101;
        for(int x : nums) {
            set.add(x);
            maxm = Math.max(maxm,x);
            minm = Math.min(minm,x);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=minm; i <= maxm ; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}