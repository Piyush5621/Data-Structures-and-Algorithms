class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int x : nums) temp.add(x);
        permutation(0,nums,res,temp);
        return res;
    }
    static void permutation(int start,int []arr,List<List<Integer>> ans,List<Integer> temp){
        if(start>=arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<arr.length;i++){
            swap(i,start,temp);
            permutation(start+1,arr,ans,temp);
            swap(start,i,temp);
        }
    }

    static void swap(int a, int b, List<Integer> arr) {
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }
}