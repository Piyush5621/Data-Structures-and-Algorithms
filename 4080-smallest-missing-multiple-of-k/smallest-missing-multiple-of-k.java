class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for( int x : nums ) set.add(x);

        for( int i=1; i <= nums.length; i++){
            if( !set.contains(k * i)){
                return k*i;
            }
        }
        return k*(nums.length+1);
    }
}