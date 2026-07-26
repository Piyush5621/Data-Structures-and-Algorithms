class Solution {
    public int maximumProduct(int[] nums) {
        int first = -1000;
        int second = -1000;
        int third = -1000;
        int minm = 1000;
        int secondminm = 1000;
        for(int i=0; i< nums.length; i++){
            if(nums[i] > first ){
                third = second;
                second = first;
                first = nums[i];
            }
            else if(nums[i] > second ){
                third = second;
                second = nums[i];
            }
            else if(nums[i]> third){
                third = nums[i];
            }

            if(nums[i] < minm){
                secondminm = minm;
                minm = nums[i];
            }
            else if(nums[i] < secondminm){
                secondminm = nums[i];
            }
        }

        return Math.max(first*second*third, first*minm*secondminm);
    }
}