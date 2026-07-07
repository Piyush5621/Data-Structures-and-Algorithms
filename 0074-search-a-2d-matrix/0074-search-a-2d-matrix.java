class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(matrix[mid][0] <= target && matrix[mid][m] >= target){
                int a = 0;
                int b = m;

                while(a <= b){
                    int mid1 = a+ (b-a)/2; 
                    if(matrix[mid][mid1]==target){
                        return true;
                    }
                    else if(matrix[mid][mid1]<target){
                        a = mid1+1;
                    }
                    else{
                        b=mid1-1;
                    }
                }
                return false;
            }
            else if(matrix[mid][m] < target){ 
                low = mid+1;    
            }
            else{
                high = mid-1; 
            }
        }
        return false;

    }
}