class Solution {
    public int[][] flipAndInvertImage(int[][] images) {
        int n = images.length;
        for(int i=0; i<n; i++){
            int j=0;
            int e=n-1;
            while(j<=e){
                int temp = images[i][j]^1;
                images[i][j]=images[i][e] ^1;
                images[i][e] = temp;
                j++;
                e--;
            }
        }

        

        return images;
    }
}