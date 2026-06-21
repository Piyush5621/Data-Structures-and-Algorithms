class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxmCan = 0;

        for(int x : candies){
            maxmCan = Math.max(maxmCan, x);
        }

        List<Boolean> ans = new ArrayList<>();

        for(int x : candies){
            if((x+extraCandies)>=maxmCan){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }

        return ans;
    }
}