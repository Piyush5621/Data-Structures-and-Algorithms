class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a,b)-> a[1]-b[1]);
        int m = queries.length;
        int res[] = new int[m];

        int qur[][] = new int[queries.length][2];
        for( int i =0; i < queries.length; i++ ){
            qur[i][0] = i;
            qur[i][1] = queries[i];
        }
        Arrays.sort(qur, (a,b) -> a[1]-b[1]);
        int start  = 0;
        int end = 0; 
        HashMap<Integer,Integer> map = new HashMap<>();
        for( int arr[] : qur ){
            int num =arr[1];
            int first  = num - x;
            int last = num;

            while( end < logs.length && logs[end][1] <= last){
                int s = logs[end][0];
                map.put(s , map.getOrDefault(s, 0)+1);
                end++;
            }

            while(start < end && logs[start][1] < first){
                int s = logs[start][0];
                int freq = map.get(s);
                freq--;
                if(freq == 0){
                    map.remove(s);
                }
                else{
                    map.put(s,freq);
                }
                start++;
            }
            res[arr[0]] = n - map.size();
        }
        return res;
    }
}