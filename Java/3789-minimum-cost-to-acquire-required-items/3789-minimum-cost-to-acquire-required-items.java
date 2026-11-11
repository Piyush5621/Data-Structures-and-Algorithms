class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long maxNeed = Math.max( need1, need2 );

        long opt1 = 1L * (long) costBoth * maxNeed;

        long opt2 = 0;

        opt2 += 1L * (long) cost1 * need1;
        opt2 += 1L * (long) cost2 * need2;
        long opt3 = 0;

        if( need1  > need2 ){
            opt3 += 1L * (long) need2 * costBoth;
            opt3  += 1L * (long) (need1 - need2) * cost1;
        }
        else{
            opt3 += 1L * (long) need1 * costBoth;
            opt3  += 1L * (long) (need2 - need1) * cost2;
        }

        return  Math.min(opt1, Math.min(opt2,opt3));
    }
}