class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int first = 0;
        int last = 0;

        for(int x : nums){
            if( x < target) first++;
            else if(x == target) last++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i< last; i++){
            ans.add(first);
            first++;
        }

        return ans;

    }
}