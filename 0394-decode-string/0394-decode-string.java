class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder temp = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    temp.append(st.pop());
                }
                st.pop();
                temp.reverse();
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.append(st.pop());
                }
                num.reverse();
                int n = Integer.parseInt(num.toString());

                while (n-- > 0) {
                    for (char d : temp.toString().toCharArray()) {
                        st.push(d);
                    }
                }
            } else {
                st.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}