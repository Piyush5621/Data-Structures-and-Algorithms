class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean vist[]=new boolean[n];
        vist[0]=true;
        Queue<Integer> q=new ArrayDeque();
        q.add(0);
        int c=1;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int nbr: rooms.get(curr)){
                if(!vist[nbr]){
                    vist[nbr]=true;
                    q.add(nbr);
                    c++;
                }
            }
        }
        return (c==n)? true: false;
    }
}