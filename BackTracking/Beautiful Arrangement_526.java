class Solution {
    public int countArrangement(int n) {
        int arr[] = new int[n+1];
        for(int i=0; i<=n; i++) arr[i] = i;
        return  backT(1,arr);
    }

    int backT(int idx,int arr[]){
        if(idx == arr.length){
            return 1;
        }
        int ans = 0;
        for(int i=idx;i<arr.length;i++){
            if(arr[i] % idx == 0 || idx % arr[i] == 0){
                swap(i,idx,arr);
                ans+=backT(idx+1,arr);
                swap(i,idx,arr);
            }
            
        }
        return ans;
    }

    void swap(int i,int j,int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}