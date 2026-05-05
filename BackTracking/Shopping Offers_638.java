class Solution {
    int minm = Integer.MAX_VALUE; 
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        backT(0,price,special,needs,0);
        return minm;
    }

    void backT(int idx, List<Integer> price, List<List<Integer>> special, List<Integer> needs,int cost){
        if(idx==special.size()){
            for(int k=0;k<needs.size();k++){
                if(needs.get(k)>0){
                    cost += (needs.get(k)*price.get(k));
                }
            }
            minm = Math.min(minm,cost);
            return;
        }
        backT(idx+1,price,special,needs,cost);
        List<Integer> temp = special.get(idx);
        boolean flag = true;
        for(int j=0;j<needs.size();j++){
            if(temp.get(j)>needs.get(j)){
                flag = false;
                break;
            }
        }
        if(flag){
            for(int j=0;j<needs.size();j++){
                needs.set(j,needs.get(j)- temp.get(j));
            }
            cost = cost+ temp.get(temp.size()-1);
            backT(idx,price,special,needs,cost);
            for(int j=0;j<needs.size();j++){
                needs.set(j,needs.get(j)+temp.get(j));
            }
        }
    }
}

// or

class Solution {
    int minm = Integer.MAX_VALUE; 
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        backT(0,price,special,needs,0);
        return minm;
    }

    void backT(int idx, List<Integer> price, List<List<Integer>> special, List<Integer> needs,int cost){
        int direct = cost;
        for(int k=0;k<needs.size();k++){
            if(needs.get(k)>0){
                direct += (needs.get(k)*price.get(k));
            }
        }
        minm = Math.min(minm,direct);
        
        for(int i=idx;i<special.size();i++){
            List<Integer> temp = special.get(i);
            boolean flag = true;
            for(int j=0;j<needs.size();j++){
                if(temp.get(j)>needs.get(j)){
                    flag = false;
                    break;
                }
            }
            if(!flag) continue;
            else{
                for(int j=0;j<needs.size();j++){
                    needs.set(j,needs.get(j)- temp.get(j));
                }
                cost = cost+ temp.get(temp.size()-1);
                backT(i,price,special,needs,cost);
                for(int j=0;j<needs.size();j++){
                    needs.set(j,needs.get(j)+temp.get(j));
                }
                cost = cost- temp.get(temp.size()-1);
            }
        }
    }
}