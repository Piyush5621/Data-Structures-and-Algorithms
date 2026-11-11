class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long minNeed = Math.min( need1, need2 );

        long Tcost1 = 1L * (long) minNeed * costBoth;
        Tcost1 += 1L * (long) (need1 - minNeed) *  cost1;
        Tcost1 += 1L * (long) (need2 - minNeed ) * cost2;

        long maxNeed = Math.max(need1, need2);
        long Tcost2 = 1L * (long) maxNeed * costBoth;  
        long Tcost3 = 1L * (long) need1 * cost1 + 1L * (long) need2 * cost2;

        return Math.min(Tcost1, Math.min(Tcost2,Tcost3));
    }
}