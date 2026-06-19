class NumArray {
    int tree[];
    int n ;
    int arr[];
    public int contruct(int nums[],int ss, int se, int si){
        if(ss==se){
            tree[si] = nums[ss];
            return nums[ss];
        }
        int mid = (ss+se)/2;
        tree[si] = contruct(nums,ss,mid,2*si+1)+contruct(nums,mid+1,se,2*si+2);
        return tree[si];
    }

    public NumArray(int[] nums) {
        arr=nums;
        n=nums.length;
        if(n==0) return;
        tree = new int[4*nums.length];
        contruct(nums,0,nums.length-1,0);
    }
    
    public void update(int index, int val) {
        int diff = val - arr[index];
        arr[index] = val;
        updateRec(0,n-1,index,0,diff);
    }

    public void updateRec(int ss,int se, int i , int si,int diff){
        if(ss > i || se < i) return;
        tree[si] = tree[si]+diff;

        if(ss<se){
            int mid = (ss+se)/2;
            updateRec(ss,mid,i,2*si+1,diff);
            updateRec(mid+1,se,i,2*si+2,diff);
        }
    }
    
    public int sumRange(int left, int right) {
        return getsum(0,n-1,left,right,0);
    }

    public int getsum(int ss,int se,int left,int right,int si){
        if(se<left || ss>right) return 0;
        if(ss >= left && se<= right) return tree[si];

        int mid = (ss+se)/2;
        return getsum(ss,mid,left,right,2*si+1)+getsum(mid+1,se,left,right,2*si+2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */