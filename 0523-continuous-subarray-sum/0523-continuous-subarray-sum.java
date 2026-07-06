class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0,-1);
        int pSum = 0;
        for(int i = 0; i < n ; i++){
            pSum = (pSum+nums[i])%k;

            if(map.containsKey(pSum)){
                if(i-map.get(pSum) >=2 ){
                    return true;
                }
            }
            else{
                map.put(pSum, i);
            }
        }
        return false;
    }
}