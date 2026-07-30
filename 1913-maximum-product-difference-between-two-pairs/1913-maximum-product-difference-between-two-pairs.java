class Solution {
    public int maxProductDifference(int[] nums) {
        int maxOne = 1,maxTwo = 1;
        int minOne = Integer.MAX_VALUE,minTwo = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > maxTwo){
                if(num > maxOne){
                    maxTwo = maxOne;
                    maxOne = num;
                }else{
                    maxTwo = num;
                }
            }
            if(num < minTwo){
                if(num < minOne){
                    minTwo = minOne;
                    minOne = num;
                }else{
                    minTwo = num;
                }
            }
        }        
        return (maxOne*maxTwo) - (minOne*minTwo);
    }
}