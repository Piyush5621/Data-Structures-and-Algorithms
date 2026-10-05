class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> list = new ArrayList<>();
        for(int i= 0; i< nums.length; i++){
            if( nums[i] == x){
                list.add(i);
            }
        }
        int ans[] = new int[queries.length];
        int k = 0;
        for( int i=0; i < queries.length; i++ ){
            if(queries[i] > list.size()){
                ans[k] = -1;
            }
            else{
                ans[k] = list.get(queries[i]-1);
            }
            k++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna