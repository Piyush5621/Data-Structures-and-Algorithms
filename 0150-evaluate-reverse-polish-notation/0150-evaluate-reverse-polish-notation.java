class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for( String str :  tokens ){        
            switch(str){
                case "+": 
                    int c = st.pop();
                    int d = st.pop();
                    st.add(c+d);
                    break;   
                case "-": 
                    int e = st.pop();
                    int f = st.pop();
                    st.add(f-e);
                    break;
                case "*": 
                    int g = st.pop();
                    int h = st.pop();
                    st.push(g*h);
                    break;
                case "/": 
                    int a = st.pop();
                    int b = st.pop();
                    st.add(b/a);
                    break;
                default:
                    st.push(Integer.parseInt(str));
                    break;
            }
        }

        return st.pop();
    }
}