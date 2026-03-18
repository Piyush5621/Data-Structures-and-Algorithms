class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x: piles) pq.add(x);
        int ans=0;
        while(k-->0){
            int x=pq.poll();
            pq.add(x-x/2);
        }
        while(!pq.isEmpty()) ans+=pq.poll();
        return ans;
    }
}