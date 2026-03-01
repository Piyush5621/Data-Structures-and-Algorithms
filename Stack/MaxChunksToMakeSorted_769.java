class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> s=new Stack<>();
        for(int num: arr){
            if(s.isEmpty() || num>=s.peek()){
                s.push(num);
            }
            else{
                int max=s.pop();

                while(!s.isEmpty() && s.peek()>num){  // yaha pmax ko nikalne ke baad jo baki element stack main hai usme check kr rha ki agr num se koi choka hai to usko hta do 
                    s.pop();
                }
                s.push(max);
            }
        }
        return s.size();
    }
}