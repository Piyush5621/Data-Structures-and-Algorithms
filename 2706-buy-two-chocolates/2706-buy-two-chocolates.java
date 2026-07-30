class Solution {
    public int buyChoco(int[] prices, int money) {
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;

        for(int num : prices){
            if(num < minOne){
                minTwo = minOne;
                minOne = num;
            }
            else if(num < minTwo){
                minTwo = num;
            }
        }
        return (minOne+minTwo <= money) ? money-(minOne+minTwo): money;
    }
}