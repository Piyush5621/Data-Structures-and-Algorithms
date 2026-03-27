class Solution {
    int[] par;
    int rank[];
    class Disjoint{
        Disjoint(int n){
            par=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++) par[i]=i;
        }
        int find(int x){
            if(par[x]==x){
                return x;
            }
            return find(par[x]);
        }
        void union(int a,int b){
            int x_ref=find(a);
            int y_ref=find(b);

            if(rank[x_ref]<rank[y_ref]){
                par[x_ref]=y_ref;
            }
            else if(rank[x_ref]>rank[y_ref]){
                par[y_ref]=x_ref;
            }
            else{
                par[y_ref]=x_ref;
                rank[x_ref]++;

            }
        }
    } 
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Disjoint dj=new Disjoint(accounts.size());
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String temp=accounts.get(i).get(j);
                if(!map.containsKey(temp)){
                    map.put(temp,i);
                }
                else{
                    dj.union(i,map.get(temp));
                }
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<accounts.size();i++) ans.add(new ArrayList<>());
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            int x=dj.find(entry.getValue());
            ans.get(x).add(entry.getKey());
        }

        for(List<String> li: ans){
            Collections.sort(li);
        }

        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            List<String> li=ans.get(i);
            if(li.size()>0){
                List<String> list=new ArrayList<>();
                list.add(accounts.get(i).get(0));
                list.addAll(li);
                res.add(list);
            }
        }
        return res;
    }
}