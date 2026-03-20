class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        int id[]=new int[n];
        for( int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            id[edges[i][1]]++;
        }

        Queue<Integer> q=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(id[i]==0){
                q.offer(i);
            }
        }
        int freq[][]=new int[n][26];
        int len=0;
        int ans=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            freq[curr][colors.charAt(curr)-'a']++;
            ans=Math.max(ans,freq[curr][colors.charAt(curr)-'a']);
            for(int x: adjList.get(curr)){
                for(int c=0;c<26;c++){
                    freq[x][c]=Math.max(freq[x][c],freq[curr][c]);
                }
                id[x]--;
                if(id[x]==0){
                    q.offer(x);
                }
            }
            len++;
        }

        return (len==n)? ans: -1;
    }
}