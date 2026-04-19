class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int k=0;
        int arr1[]=new int[n/2+1];
        int arr2[]=new int[n/2+1];
        boolean exist=false;
        while(k<n){
            if(nums[k]<0){
                arr1[i++]=nums[k];
            }
            else{
                arr2[j++]=nums[k];
            }
            k++;
        }
        i=0;
        j=0;
        for(k=0;k<n;k++){
            if(exist){
                nums[k]=arr1[i++];
                exist=false;
            }
            else{
                nums[k]=arr2[j++];
                exist=true;
            }
        }
        return nums;
    }
}