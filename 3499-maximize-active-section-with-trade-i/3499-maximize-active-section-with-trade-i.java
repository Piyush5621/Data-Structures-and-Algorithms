class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='1') ones++;
        }
        s = '1'+ s +'1';

        List<Character> ch = new ArrayList<>();
        List<Integer> cont =  new ArrayList<>();
        int i = 0;
        while( i < s.length()){
            char cr = s.charAt(i);
            int c = 0;
            while(i < s.length() && s.charAt(i) == cr){
                i++;
                c++;
            }
            ch.add(cr);
            cont.add(c);
        }
        int gain = 0;
        for(int j = 1; j < ch.size()-1; j++){
            char cr = ch.get(j);

            if(cr =='1'){
                if(ch.get(j-1)== '0' && ch.get(j+1)== '0'){
                    gain = Math.max(gain , cont.get(j-1)+cont.get(j+1));
                }
            }
        }

        return ones+gain;
    }
}