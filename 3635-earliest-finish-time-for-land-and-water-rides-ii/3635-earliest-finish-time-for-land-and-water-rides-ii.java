class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int currL = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            currL = Math.min(currL,landStartTime[i]+landDuration[i]);
        }
    
        int case1 = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            int temp1 = currL; 
            int wt=0;
            if(temp1>waterStartTime[i]){
                wt = waterDuration[i];
            }
            else{
                wt = (waterStartTime[i]-temp1)+waterDuration[i];
            }
            case1=Math.min(case1,currL+wt);
        }

        int currW = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            currW = Math.min(currW,waterStartTime[i]+waterDuration[i]);
        }
    
        int case2 = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int wt=0;
            if(currW>landStartTime[i]){
                wt = landDuration[i];
            }
            else{
                wt = (landStartTime[i]-currW)+landDuration[i];
            }
            case2=Math.min(case2,currW+wt);
        }
        return Math.min(case1,case2);

    }
}