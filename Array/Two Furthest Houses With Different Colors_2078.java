class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ans = 0; 
        int left =0;
        int right = n-1;
        while(right >=0 && colors[0]==colors[right]) right--;
        ans = Math.max(ans,right);
        while(left < n && colors[n-1]==colors[left]) left++;
        ans = Math.max(ans, n-left-1);
        return ans;
    }
}