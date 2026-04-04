class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            int x=asteroids[i];
            if(s.isEmpty()){
                s.add(x);
                continue;
            }
            int top=s.peek();
            if(top>0 && x<0){
                while(!s.isEmpty() && s.peek()>0 && Math.abs(s.peek())< Math.abs(x)){
                    s.pop();
                }
                if( !s.isEmpty() && s.peek()>0  &&Math.abs(s.peek()) == Math.abs(x)){
                    s.pop();
                    continue;
                }
                if (!s.isEmpty() && s.peek() > 0) {
                    continue;
                }
            }
            s.add(x);
        }
        int m=s.size();
        int ans[]=new int[m];
        for(int i=m-1;i>=0;i--){
            ans[i]=s.pop();
        }

        return ans;
    }
}