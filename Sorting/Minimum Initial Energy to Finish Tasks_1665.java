class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks,(a,b)->(b[1] - b[0]) - (a[1] - a[0]));
        int ans = 0;
        int sum = 0;
        for(int arr[] : tasks ){
            ans = Math.max(ans,arr[1]+sum);
            sum+=arr[0];
        }
        return ans;
    }
}