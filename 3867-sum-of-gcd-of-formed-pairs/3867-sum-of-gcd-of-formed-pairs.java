class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int prefixGcd[] = new int[n];
        int maxm = nums[0];
        prefixGcd[0] = nums[0];
        for( int i = 0 ; i < n ; i++ ){
            maxm = Math.max(maxm, nums[i]);
            prefixGcd[i] = gcd(nums[i],maxm);
        }

        Arrays.sort(prefixGcd);

        int low= 0;
        int high = n-1;
        long ans = 0;
        while(low < high ){
            ans += gcd(prefixGcd[low],prefixGcd[high]);
            low++;
            high--;
        }
        return ans;
    }

    int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}