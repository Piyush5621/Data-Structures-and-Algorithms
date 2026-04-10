class Solution {
    HashMap<Integer,Integer> par=new HashMap<>();
    HashMap<Integer,Integer> rank=new HashMap<>();
    class Dsu{
        int find(int x){
            if(par.get(x).equals(x)) return x;
            int root = find(par.get(x));
            par.put(x,root); 
            return root;
        }

        void union(int a,int b){
            int ra = find(a);
            int rb = find(b);
            if(ra == rb) return;
            if(rank.get(ra) < rank.get(rb)){
                par.put(ra,rb);
            }
            else if(rank.get(ra) > rank.get(rb)){
                par.put(rb,ra); 
            }
            else{
                par.put(rb,ra);
                rank.put(ra,rank.getOrDefault(ra,0)+1);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        Dsu d = new Dsu();
        int offset = 10001;
        HashSet<Integer> set = new HashSet<>();
        for(int arr[] : stones){
            int a = arr[0];
            int b = arr[1]+offset;
            if(!par.containsKey(a)){
                par.put(a,a);
                rank.put(a,0);
            }
            if(!par.containsKey(b)){
                par.put(b,b);
                rank.put(b,0);
            }
            d.union(a,b);
            set.add(a);
            set.add(b);
        }

        int com=0;
        for(int x: set){
            if(d.find(x)== x){
                com++;
            }
        }
        return n-com;

    }
}