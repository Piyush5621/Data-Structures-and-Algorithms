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
                j++;
                e--;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                images[i][j]= (images[i][j]==0)? 1:0;
            }
        }

        return images;
    }
}