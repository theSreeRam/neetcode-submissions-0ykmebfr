class Solution {

    private boolean isOperator(String s) {
        if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
            return true;
        } else {
            return false;
        }
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=0; i<tokens.length; i++){
            String token = tokens[i];
            if(isOperator(token)){
                int a = st.pop();
                int b = st.pop();   
                if(token.equals("+")){
                    st.push(a+b);
                } else if(token.equals("-")){
                    st.push(b-a);
                } else if(token.equals("*")){
                    st.push(a*b);
                } else {
                    st.push(b/a);
                }
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
