class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int freq[] = new int[101];
        boolean vis[] = new boolean[101];
        for(int i = 0; i<nums1.length; i++){
            if(!vis[nums1[i]]){
                freq[nums1[i]]++;
                vis[nums1[i]]= true;
            }
           
        }
        vis = new boolean[101];
        for(int i = 0; i<nums2.length; i++){
            if(!vis[nums2[i]]){
                freq[nums2[i]]++;
                vis[nums2[i]]= true;
            }
        }
        vis = new boolean[101];
        for(int i = 0; i<nums3.length; i++){
            if(!vis[nums3[i]]){
                freq[nums3[i]]++;
                vis[nums3[i]]= true;
            }
        }
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < 101 ;i++){
            if(freq[i]>=2){
                ans.add(i);
            }
        }

        return ans;
    }
}