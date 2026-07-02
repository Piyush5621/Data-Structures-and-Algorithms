class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int numOdd = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i]%2 == 0) nums[i]=0;
            else nums[i] = 1; 
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int left = 0;
        int ans = 0;
        map.put(0,1);
        for(int i = 0; i < n ; i++){
            prefixSum += nums[i];
            if(map.containsKey(prefixSum - k)){
                ans+=map.get(prefixSum - k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
            
        }

        return map.containsKey(k)? ans : 0;

    }
}