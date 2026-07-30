class Solution {
    public int minimumPushes(String word) {

        int count = 0;
        int ans = 0;
        for( int i=0; i< word.length(); i++ ){
            count++;
            int k =(int)Math.ceil(count/8);
            if(count%8 !=0) k++;
            ans = ans+k;
        }

        return ans;

        
    }
}