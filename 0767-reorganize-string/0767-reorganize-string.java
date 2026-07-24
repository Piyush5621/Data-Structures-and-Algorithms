class Solution {
    class Pair{
        char first;
        int second;
        Pair(char a, int b){
            first = a;
            second = b;
        }
    }
    public String reorganizeString(String s) {
        StringBuilder str = new StringBuilder();

        int freq[] = new int[26];

        for(char c : s.toCharArray()) freq[c-'a']++;


        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> b.second - a.second
        );

        for(int i =0 ; i< 26; i++){
            if(freq[i]>0){
                pq.add(new Pair((char)(i+'a'), freq[i]));
            } 
        }

        while(pq.size() > 1){
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();

            str.append(p1.first);
            str.append(p2.first);
            freq[p1.first-'a']--;
            freq[p2.first-'a']--;
            if(freq[p1.first-'a'] > 0){
                pq.offer(new Pair(p1.first,p1.second-1));
            }
            if(freq[p2.first-'a'] > 0){
                pq.offer(new Pair(p2.first,p2.second-1));
            }
        }
        if(!pq.isEmpty()){
            Pair p = pq.poll();
            str.append(p.first);
            freq[p.first-'a']--;
            if(freq[p.first-'a']!=0){
                return "";
            }
        }
        return str.toString();

    }
}