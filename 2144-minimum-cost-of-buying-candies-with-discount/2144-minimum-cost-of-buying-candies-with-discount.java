class Solution {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : cost){
            pq.add(x);
        }
        int minmcost = 0;
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();

            if(!pq.isEmpty()){
                pq.poll();
            }
            minmcost += (a+b);
        }

        return (!pq.isEmpty()) ? minmcost+pq.peek(): minmcost;
    }
}