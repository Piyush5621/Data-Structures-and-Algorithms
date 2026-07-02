class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;
        int prefixSum = 0;
        for(int i = 0; i < n; i++){
            int x = nums[i];
            prefixSum+=x;
            map.put(x, map.getOrDefault(x,0)+1);
            while(map.get(x)>1){
                int y = nums[left]; 
                prefixSum-=y;
                map.put(y,map.get(y)-1);
                if(map.get(y)==0){
                    map.remove(y);
                }
                left++;
            }

            ans = Math.max(ans, prefixSum);
        }
        return ans;
    }
}