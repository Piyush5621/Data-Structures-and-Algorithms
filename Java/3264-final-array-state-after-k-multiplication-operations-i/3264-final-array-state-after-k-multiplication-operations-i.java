class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
         PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a[0] != b[0] ) return a[0] - b[0];
                return a[1] - b[1];
            }
        );

        for( int i = 0; i < nums.length; i++ ){
            pq.add(new int[]{nums[i],i});
        }

        while( k-- > 0 && !pq.isEmpty()){
            int curr[] = pq.poll();
            int mul = multiplier * curr[0];
            pq.add(new int[]{mul,curr[1]});
        } 

        int ans[] = new int[pq.size()];

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            ans[curr[1]] = curr[0];
        }

        return ans;
    }
}