class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long prefixSum[] = new long[n];
        prefixSum[0] =tasks[0]; 

        for(int i = 1 ; i < n ; i++ ){
            prefixSum[i] = prefixSum[i-1]+tasks[i];
        }
        int m = shifts.length;
        int ans[] = new int[m];

        long completed = 0;
        for(int i = 0; i < m; i++){

            completed += shifts[i];

            if(completed >= prefixSum[n-1]){
                ans[i] = 0 ;
                completed = 0;
                continue;
            }

            int x = search(prefixSum,completed);

            ans[i] = x;
            
        }

        return ans;
        
    }

    int search(long prefix[] , long num ){
        int res = -1;
        int start = 0; 
        int end = prefix.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(prefix[mid] <= num ){
                res = mid;
                start = mid+1;
            } 
            else{
                end = mid -1;
            }
        }
        int n = prefix.length;
        return (res==-1) ? n : n-(res+1) ;
    }
}