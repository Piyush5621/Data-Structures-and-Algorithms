class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> cars = new ArrayList<>();
        int n = speed.length;
        for( int i = 0; i < n; i++ ){
            cars.add(new int[]{position[i],speed[i]});
        }

        cars.sort((a,b)-> b[0]-a[0]);
        double prevT = -1;
        int fleet = 0;
        for(int []car : cars ){
            double time = (double)(target - car[0])/car[1];
            if(time > prevT ){
                fleet++;
                prevT = time;
            }

        }
        return fleet;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna