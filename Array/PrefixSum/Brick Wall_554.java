class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
    
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int prefix=0;
            for (int j = 0; j < wall.get(i).size()-1; j++) {
                prefix += wall.get(i).get(j);
                map.put(prefix,map.getOrDefault(prefix,0)+1);
            }
        }
        int maxm = 0;
        for(int x : map.values()){
            maxm=Math.max(maxm,x);
        }

        return n-maxm;
    }
}