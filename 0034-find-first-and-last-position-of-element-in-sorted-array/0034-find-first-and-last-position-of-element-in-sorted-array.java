class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIdx = searchFirst(nums,target,0,nums.length-1);
        int secondIdx = searchLast(nums,target,0,nums.length-1);

        return new int[]{firstIdx,secondIdx};
    }

    int searchFirst(int nums[], int tar, int start, int end){
        int ans =-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(nums[mid]==tar){
                ans = mid;
                end = mid-1;
            }
            else if(nums[mid]<tar){
                start=mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    int searchLast(int nums[], int tar, int start, int end){
        int ans =-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(nums[mid]==tar){
                ans = mid;
                start = mid+1;
            }
            else if(nums[mid]<tar){
                start=mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
}