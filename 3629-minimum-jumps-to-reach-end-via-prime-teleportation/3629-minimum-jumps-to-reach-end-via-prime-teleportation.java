class Solution {
    class Pair{
        int idx;
        int step;
        Pair(int a,int b){
            idx = a;
            step = b;
        }
    }
    boolean isPrime(int num){
        if(num<=1) return false;
        if(num<=3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for(int i=5;i*i<=num;i+=6){
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();

       for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int p = 2; p * p <= x; p++) {
                if (x % p == 0) {
                    map.computeIfAbsent(p,k->new ArrayList<>()).add(i);
                    while (x % p == 0) {
                        x /= p;
                    }
                }
            }
            if (x > 1) {
                map.computeIfAbsent(x,k->new ArrayList<>()).add(i);
            }
        }

        boolean vis[] = new boolean[n];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0));
        vis[0] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int in = p.idx;
            int st = p.step;
            if(in==n-1){
                return st;
            }
            if(isPrime(nums[in])){
                if(map.containsKey(nums[in])){
                    for(int nbr : map.get(nums[in])){
                        if(!vis[nbr]){
                            q.add(new Pair(nbr, st+1));
                            vis[nbr] = true;
                        }
                    }
                    map.remove(nums[in]);  
                }
            }
            if(in+1<n && !vis[in+1]){
                q.add(new Pair(in+1,st+1));
                vis[in+1] = true;
            }
            if(in-1>=0 && !vis[in-1]){
                q.add(new Pair(in-1,st+1));
                vis[in-1]= true;
            }
        }
        return -1;
    }
}