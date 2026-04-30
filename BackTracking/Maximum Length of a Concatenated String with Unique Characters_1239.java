class Solution {
    int maxm =0;
    public int maxLength(List<String> arr) {
        int freq[] = new int[26];
        backT(0,new StringBuilder(),freq,arr);
        return maxm;
    }

    void backT(int idx,StringBuilder temp, int[] freq, List<String> arr){
        
        maxm = Math.max(maxm,temp.length());

        for(int i=idx;i<arr.size();i++){
            String str = arr.get(i);
            boolean clear = true;
            int local[]=new int[26];
            for(int j=0;j<str.length();j++){
                if(local[str.charAt(j)-'a']>0||freq[str.charAt(j)-'a']>0){
                    clear = false;
                    break;
                }
                local[str.charAt(j)-'a']++;
            }
            if(!clear) continue;
            for(int j=0;j<26;j++){
                freq[j]+=local[j];
            }
            temp.append(str);
            backT(i+1,temp,freq,arr);
            temp.delete(temp.length()-str.length(),temp.length());
            for(int j=0;j<26;j++){
                freq[j]-=local[j];
            }
        }
    }
}