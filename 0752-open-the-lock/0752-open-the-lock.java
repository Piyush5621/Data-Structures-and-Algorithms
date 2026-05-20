class pair{
    String str;
    int count;
    pair(String ss , int c){
        str = ss;
        count = c;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for(String s : deadends) set.add(s);
        if(set.contains("0000")) return -1;
        HashSet<String> visited = new HashSet<>();
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair("0000",0));
        visited.add("0000");
        while(!q.isEmpty()){
            pair p = q.poll();
            StringBuilder s = new StringBuilder(p.str);
            int c = p.count;
            if(set.contains(s.toString())) continue;
            if(s.toString().equals(target)){
                return c;
            }
            for(int i=0;i<4;i++){
                char[] arr = s.toString().toCharArray();
                arr[i] = (char)((((s.charAt(i) - '0') + 1) % 10) + '0');
                String up = new String(arr);
                if(!visited.contains(up) && !set.contains(up)){
                    visited.add(up);
                    q.add(new pair(up,c+1));
                }
                arr =  s.toString().toCharArray();
                arr[i] = (char)((((s.charAt(i) - '0') + 9) % 10) + '0');  
                String down = new String(arr);
                if(!visited.contains(down) && !set.contains(down)){
                    visited.add(down);
                    q.add(new pair(down,c+1));
                }
            }
        }
        return -1;
    }
}