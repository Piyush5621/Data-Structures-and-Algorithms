class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int start = 1;
        int end = position[n-1] - position[0];

        int ans = 1;
        while(start <= end ){
            int mid = start + (end-start)/2;

            int maxGap = findGap( mid ,position);

            if(maxGap >= m){
                ans = mid;
                start = mid+1; 
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }

    public int findGap(int mid , int arr[]){
        int Nb = 1;
        int n = arr.length;
        int last = arr[0];
        for(int i =0; i<n ; i++){
            if(arr[i]-last>=mid){
                Nb++;
                last = arr[i];
            }
        }
        return Nb;
    }
}