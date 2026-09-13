class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> m1 = new ArrayList<>();
        List<int[]> m2 = new ArrayList<>();
        int n = img1.length;
        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < n; j++ ){
                if(img1[i][j] == 1 ) m1.add(new int[]{i,j});
                if(img2[i][j] == 1 ) m2.add(new int[]{i,j});
            }
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for( int i1[] : m1 ){
            for( int i2[] :  m2 ){
                int row = i2[0] - i1[0];
                int col = i2[1] - i1[1];
                int dis = row * 10000 + col;
                map.put(dis,map.getOrDefault(dis,0)+1);
                max = Math.max(max,map.get(dis));
            }
        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna