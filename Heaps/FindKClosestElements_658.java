class Pair{
    int key;
    int value;
    Pair(int a,int b){
        this.key=a;
        this.value=b;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.value!=b.value) return b.value-a.value;
                return b.key-a.key;
            }
        ); 

        for(int i=0;i<arr.length;i++){
            pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
        }

        int i=pq.size();
        while(i-->k){
            pq.poll();
        }
        List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().key);
        }
        Collections.sort(ans);

        return ans;
    }
}