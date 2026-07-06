class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(b[1]!=a[1]){
                return b[1]-a[1]; 
            }
            return a[0]- b[0];
        });
        int cnt =0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int  i= 1; i < intervals.length; i++){
            if((intervals[i][0] >= left && intervals[i][1]<=right)){
                cnt++;
            }
            left = Math.min(left , intervals[i][0]);
            right = Math.max(right,intervals[i][1]);
        }

        return intervals.length - cnt;
    }
}