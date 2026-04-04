class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s=new Stack<>();
        int n=temperatures.length;
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int x=temperatures[i];
            while(!s.isEmpty() && temperatures[s.peek()]<=x){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]=0;
            }
            else{
                ans[i]=s.peek()-i;
            }
            s.add(i);
        }

        return ans;
    }
}