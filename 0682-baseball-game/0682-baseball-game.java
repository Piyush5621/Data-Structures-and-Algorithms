class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<operations.length; i++){
            String str = operations[i];
            int n = list.size();
            if(str.equals("+")){
                if(n>1){
                    list.add(list.get(n-1)+list.get(n-2));
                }
            }
            else if(str.equals("D")){
                int e = 2 * list.get(n - 1);
                list.add(e);
            }
            else if(str.equals("C")){
                if(!list.isEmpty()){
                    list.remove(n-1);
                }
            }
            else{
                list.add(Integer.parseInt(str));
            }
        }
        int summ = 0;
        for(int x : list) summ+=x;
        return summ;
    }
}