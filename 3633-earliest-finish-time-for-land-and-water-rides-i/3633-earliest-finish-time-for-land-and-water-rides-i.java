class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int curr = landStartTime[i]+landDuration[i];
                if(waterStartTime[j]<=curr){
                    curr = curr + waterDuration[j];
                }
                else{
                    int d = waterStartTime[j] - curr;
                    curr = curr + d + waterDuration[j];
                }

                case1 = Math.min(case1,curr);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int curr = waterStartTime[i]+waterDuration[i];
                if(landStartTime[j]<=curr){
                    curr = curr + landDuration[j];
                }
                else{
                    int d = landStartTime[j] - curr;
                    curr = curr + d + landDuration[j];
                }

                case2 = Math.min(case2,curr);
            }
        }

        return Math.min(case1,case2);
    }
}