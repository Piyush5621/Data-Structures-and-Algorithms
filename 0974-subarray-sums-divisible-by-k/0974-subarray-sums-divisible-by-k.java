class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0,1);
        int ans = 0 ;
        for(int i =0; i<n ;i++){
            prefixSum= (prefixSum+nums[i])%k;
            if(prefixSum<0) prefixSum+=k;
            if(map.containsKey(prefixSum)){
                ans +=map.get(prefixSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return ans;
    }
}