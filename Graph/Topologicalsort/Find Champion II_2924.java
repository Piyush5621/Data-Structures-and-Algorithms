class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[]=new int[n];
        for(int arr[] : edges){
            indegree[arr[1]]++;
        }
        int ans=-1;
        int cnt=0;
        for(int i=0;i<n ;i++){
            if(indegree[i]==0){
                ans =i;
                cnt++;
            }
        }

        return (cnt> 1 )? -1: ans;
    }
}