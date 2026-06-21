class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxmCost = 0;
        for(int x : costs){
            maxmCost = Math.max(maxmCost,x);
        }

        int freq[] = new int[maxmCost+1];

        for(int x : costs){
            freq[x]++;
        }
        
        int ccoins = 0;
        int c = 0;
        
        for(int i=0; i<=maxmCost && coins>=i; i++){
            if(freq[i]==0) continue;
            int canBuy = Math.min(freq[i],coins/i);
            c += canBuy;
            coins -=(canBuy*i);
        }

        return c;
    }
}