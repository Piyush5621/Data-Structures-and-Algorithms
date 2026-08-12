class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int left = 0;
        int ans = 0;
        for( int i = 0; i < n ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i]) > k){
                int num = nums[left];
                map.put(num, map.get(num)-1);
                if(map.get(num)==0){
                    map.remove(num);
                }
                left++;
            } 

            ans = Math.max(ans, i - left + 1); 
        }
        return ans;
    }
}