class StockSpanner {
    Stack<int[]> s1;
    public StockSpanner() {
        s1 = new Stack<>();
    }
    
    public int next(int price) {
        
        int span = 1;
        while(!s1.isEmpty() && s1.peek()[0] <= price){
            span +=s1.pop()[1];
        } 
       
        s1.push(new int[]{price,span});

        return span;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */