class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = -1;
        int end = -1;
        for( int arr[] : intervals ){
            if( start == -1){
                start = arr[0];
                end = arr[1];
            }
            else if( arr[0] <= end){
                end = Math.max(end, arr[1]);
            }
            else{
                res.add(new int[]{start , end});
                start = arr[0];
                end = arr[1];
            }
        }

        if( start !=-1){
            res.add( new int[]{start ,end});
        }

        return res.toArray(new int[res.size()][]);
        
    }
}