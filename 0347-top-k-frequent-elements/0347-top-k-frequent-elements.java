class Pair{
    int key;
    int value;
    Pair(int a,int b){
        key=a;
        value=b;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x: nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)-> a.value-b.value
        );

        for(int x: map.keySet()){
            int v=map.get(x);
            pq.add(new Pair(x,v));
        }
        int i=pq.size();
        while(i-->k){
            pq.poll();
        }
        i=0;
        int ans[]=new int[k];
        while(!pq.isEmpty()){
            ans[i]=pq.poll().key;
            i++;
        }
        
        return ans;

    }
}