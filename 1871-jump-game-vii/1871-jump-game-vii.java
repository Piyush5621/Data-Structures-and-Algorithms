class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int farthest=0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean visited[] = new boolean[n];
        visited[0] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==n-1){
                return true;
            }
            int start = Math.max(curr+minJump,farthest);
            int end = Math.min(curr+maxJump,n-1);

            for(int i=start;i<=end;i++){
                if(s.charAt(i)=='0' && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
            farthest = end+1;
        }
        return false;
    }
}