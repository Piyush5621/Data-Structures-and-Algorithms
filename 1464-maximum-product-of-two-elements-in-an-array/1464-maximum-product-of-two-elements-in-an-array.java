class Solution {
    public int maxProduct(int[] nums) {
        int m1 = -1;
        int m2 = -1;
        for( int x : nums ){
            if( x > m1){
                m2 = m1;
                m1 = x;
            }
            else if(x > m2){
                m2 = x;
            }
        }
        return (m2-1)*(m1-1);
    }
}