class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans=0L;
        int i=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x: nums){
            pq.add(x);
        }
        while(i++<k){
            int x=pq.poll();
            pq.add((int)Math.ceil((double)x/3));
            ans+=x;
        }
        return ans;
    }
}