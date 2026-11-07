class Solution {
    class pair{
        int w;
        int idx;
        pair(int a, int b){
            this.w = a;
            this.idx = b;
        }
    }

    class triple{
        int time;
        int w;
        int idx;
        triple(int a, int b, int c){
            this.time = a;
            this.w = b;
            this.idx = c;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = tasks.length;

        int res[] = new int[n];

        PriorityQueue<pair> avail = new PriorityQueue<>(
            (a,b)->{
                if(a.w != b.w) return a.w - b.w;
                return a.idx - b.idx;
            }
        );

        for( int i = 0; i < servers.length; i++ ){
            avail.add(new pair(servers[i],i));
        }

        PriorityQueue<triple> taken = new PriorityQueue<>(
            (a,b)->{
                if(a.time != b.time) return a.time - b.time;
                else if (a.w != b.w) return a.w - b.w;
                return a.idx - b.idx;
            }
        );

        int currTime = 0;

        for( int i = 0; i < n; i++ ){

            currTime  = Math.max( currTime, i);

            while( !taken.isEmpty() && taken.peek().time <= currTime ){
                avail.add(new pair(taken.peek().w, taken.peek().idx));
                taken.poll();
            }

            if( avail.isEmpty() ){
                if( !taken.isEmpty()){
                    triple t = taken.poll();
                    currTime = t.time;
                    avail.add(new pair(t.w, t.idx));

                    while(!taken.isEmpty() && taken.peek().time <= currTime){
                        avail.add(new pair(taken.peek().w, taken.peek().idx));
                        taken.poll();
                    }
                }
            }

            pair p = avail.poll();
            res[i] = p.idx;

            taken.add(new triple(currTime+tasks[i], p.w, p.idx)); 
        }

        return res;

    }
}