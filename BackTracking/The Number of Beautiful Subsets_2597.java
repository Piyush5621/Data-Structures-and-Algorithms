class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        return solve(0, nums.length, nums, k,new ArrayList<>(),set);
    }
    int solve(int idx, int n, int nums[], int k , List<Integer> temp,HashSet<Integer> set){
        if(idx == n){
            return (temp.size()>0) ? 1 : 0; 
        }
        int count=0;
        count+=solve(idx+1, n, nums,k,temp,set);
        if(!set.contains(nums[idx]-k) && !set.contains(nums[idx]+k)){    
            temp.add(nums[idx]);
            set.add(nums[idx]);
            count+=solve(idx+1, n, nums,k,temp,set);
            temp.remove(temp.size()-1);
            set.remove(nums[idx]);
        }   
        return count;
    }
}