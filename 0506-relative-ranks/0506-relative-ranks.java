class Solution {
    class Pair{
        int first;
        int second;
        Pair(int a, int b){
            first = a;
            second = b;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.first-a.first);
        int n = score.length; 
        String[] ans = new String[n];
        for(int i = 0; i < n ; i++){
            pq.add(new Pair(score[i],i));
        }
        int i = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int rank = p.second;

            if(i == 0){
                ans[rank] = "Gold Medal";
            }
            else if(i == 1){
                ans[rank] = "Silver Medal";
            }
            else if(i==2){
                ans[rank] = "Bronze Medal";
            }
            else{
                String str = String.valueOf(i+1);
                ans[rank] = str;
            }
            i++;
        }

        return ans;
        
    }
}