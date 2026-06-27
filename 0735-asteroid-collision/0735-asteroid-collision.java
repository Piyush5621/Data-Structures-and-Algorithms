class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>  st = new Stack<>();
        int n = asteroids.length;

        for(int i =0; i<n ;i++){
            int x = asteroids[i];
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek()>0 && x<0){
                if(st.peek()<Math.abs(x)){
                    st.pop();
                }
                else if(st.peek()==Math.abs(x)){
                    st.pop();
                    destroyed = true;
                    break;
                }
                else{
                    destroyed = true;
                    break;
                }
            }

            if(!destroyed){
                st.add(x);
            }
        }

        int ans[] = new int[st.size()];
        for(int i = ans.length-1;i>=0; i--){
            ans[i]=  st.pop();
        }
        return ans;
    }
}