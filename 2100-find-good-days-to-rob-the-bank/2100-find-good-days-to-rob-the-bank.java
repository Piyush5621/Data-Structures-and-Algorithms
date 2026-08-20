class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int left[] = new int[n];
        int right[] = new int[n];

        int count  = 0;
        for( int  i = n-2; i >= 0 ; i--){
            if(security[i] <= security[i+1]){
                count++;
                right[i] = count; 
            }
            else{
                count = 0 ;
            }
        }

        count = 0;

        for( int  i = 1; i < n ; i++){
            if(security[i-1] >= security[i]){
                count++;
                left[i] = count; 
            }
            else{
                count = 0 ;
            }
        }  


        ArrayList<Integer> ans = new ArrayList<>();

        for( int i = 0; i< n ; i++){
            if(left[i]>= time && right[i]>= time){
                ans.add(i);
            }
        } 
        return ans;

    }
}