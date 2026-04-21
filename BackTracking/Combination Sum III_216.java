class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        rec(1,k,n,set,res,new ArrayList<>(),0);
        return res;
    }

    void rec(int start, int k, int n, HashSet<Integer> set, List<List<Integer>> res, List<Integer> temp,int sum){
        if(temp.size()==k && sum==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum>n || temp.size()>k) return;

        for(int i=start;i<=9;i++){
            if(set.contains(i)) continue;
            set.add(i);
            temp.add(i);
            sum+=i;
            rec(i+1,k,n,set,res,temp,sum);
            sum=sum-i;
            set.remove(i);
            temp.remove(temp.size()-1);
        }
    }
}