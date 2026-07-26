class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        int c =0;
        int m = flowerbed.length;
        if(m==1){
            return (flowerbed[0]==0 && n==1)? true: false;
        }
        for(int i = 0 ; i < m ;i++){
            if(i==0){
                if(flowerbed[i]==0 &&flowerbed[i+1]==0){
                    c++;
                    i++;
                }
            }
            else if(i==m-1){
                if(flowerbed[i-1]==0 &&flowerbed[i]==0){
                    c++;
                    i++;
                }
            }
            else{
                if(flowerbed[i]==0){
                    if(flowerbed[i-1]==0 && flowerbed[i+1]==0){
                        c++;
                        i++;
                    }
                }
            }
            
        }
        return (c >= n);
    }
}