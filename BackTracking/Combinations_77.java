class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        rec(1,n,k,res,new ArrayList<>());
        return res;
    }
    void rec(int start, int n, int k, List<List<Integer>> res , List<Integer>temp){

        if(k==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=n; i++){
            temp.add(i);
            rec(i+1, n , k-1, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}