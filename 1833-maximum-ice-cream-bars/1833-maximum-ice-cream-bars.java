class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ccoins = 0;
        int c = 0;
        for(int i=0; i<costs.length; i++){
            ccoins+=costs[i];
            if(ccoins>coins){
                break;
            }
            c++;
            if(ccoins==coins){
                return c;
            }
        }
        return c;
    }
}