class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int res = 0;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<n ;i++){
            prefixSum+=nums[i];
            if(map.containsKey(prefixSum - k)){
                res+=map.get(prefixSum-k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }

        return res;
    }
}