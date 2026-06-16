class Solution {
    public int heightChecker(int[] heights) {
        List<Integer> list = new ArrayList<>();

        for(int x : heights) list.add(x);
        Collections.sort(list);

        int ans = 0;
        for(int i=0; i<heights.length; i++){
            if(heights[i]!=list.get(i)){
                ans++;
            }
        }
        return ans;
    }
}