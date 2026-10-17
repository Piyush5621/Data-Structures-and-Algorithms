class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int arr[][] = new int[n][3];

        for( int i = 0; i < n; i++ ){
            arr[i][0] = digitSum(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a,b) ->{
            if( a[0] != b[0] ) return a[0] - b[0];
            return a[1] - b[1];
        });

        boolean vis[] = new boolean[n];

        int swap = 0;
        for( int i = 0; i < n; i++ ){
            if( vis[i] ||  i == arr[i][2] ) continue;
            int idx = arr[i][2];
            int cycleSize = 0;
            while( !vis[idx] ){
                cycleSize++;
                vis[idx] = true;
                idx = arr[idx][2];
            }
            swap += cycleSize - 1;
        }
        return swap;
    }

    private int digitSum(int num ){
        int sum = 0;

        while( num > 0 ){
            sum += num%10;
            num /= 10;
        }

        return sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna