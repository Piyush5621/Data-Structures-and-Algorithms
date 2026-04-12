class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        rec(0,n,nums,new ArrayList<>(),res);
        return res;
    }
    void rec(int i, int n, int nums[], List<Integer>temp, List<List<Integer>> res){
        if(temp.size()>=2){
            res.add(new ArrayList<>(temp));
        }
        HashSet<Integer> visited = new HashSet<>();

        for(int j=i;j<n;j++){
            if((temp.size()==0 || nums[j]>=temp.get(temp.size()-1) ) && !visited.contains(nums[j])){
                visited.add(nums[j]);
                temp.add(nums[j]);
                rec(j+1,n, nums, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
}