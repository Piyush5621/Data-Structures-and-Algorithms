class Solution {
    public int[][] flipAndInvertImage(int[][] images) {
        int n = images.length;
        for(int i=0; i<n; i++){
            int j=0;
            int e=n-1;
            while(j<=e){
                int temp = images[i][j];
                images[i][j]=images[i][e];
                images[i][e] = temp;
                if(j!=e){
                    images[i][j]= (images[i][j]==0)? 1:0;
                    images[i][e]= (images[i][e]==0)? 1:0;
                }else{
                    images[i][j]= (images[i][j]==0)? 1:0;
                }
                j++;
                e--;
            }
        }

        

        return images;
    }
}