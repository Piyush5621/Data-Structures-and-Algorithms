class Solution {
    class Pair{
        String str;
        double val;
        Pair(String a,double b){
            str=a;
            val=b;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String ,List<Pair>> map=new HashMap<>();
        for(int i=0;i<values.length;i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            if(!map.containsKey(a)){
                map.put(a,new ArrayList<>());
            }
            map.get(a).add(new Pair(b,values[i]));    
            if(!map.containsKey(b)){
                map.put(b,new ArrayList<>());
            } 
            double resp=1.00/values[i];  
            map.get(b).add(new Pair(a,resp));
        }
        int n=queries.size();
        double []ans=new double[n];
        int j=0;
        for(int i=0;i<n;i++){
            String a=queries.get(i).get(0);
            String b=queries.get(i).get(1);
            HashSet<String> vist=new HashSet<>();
            Queue<Pair> q=new ArrayDeque<>();
            if(!map.containsKey(a)){
                ans[j++]=-1;
                continue;
            }
            q.add(new Pair(a,1));
            vist.add(a);
            while(!q.isEmpty()){
                Pair p=q.poll();
                String par=p.str;
                double weight=p.val;
                if(par.equals(b)){
                    ans[j++]=weight;
                    break;    
                }
                if(!map.containsKey(par)) continue;
                for(Pair nbr: map.get(par)){
                    if(!vist.contains(nbr.str)){
                        double newW=nbr.val*weight;
                        q.offer(new Pair(nbr.str,newW));
                        vist.add(nbr.str);
                    }
                }
                if(q.isEmpty()){
                    ans[j++]=-1;
                }
            }
        }
        return ans;
    }
}