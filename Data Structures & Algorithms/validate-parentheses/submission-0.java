class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(int i=0;i<s.length(); i++){
            if((s.charAt(i)=='(') || (s.charAt(i)=='[') || (s.charAt(i)=='{')) {
                //opening bracket put it in stack
                st.push(s.charAt(i));
            } else {
                //try to match
                if(st.isEmpty()){
                    return false;
                }
                if(s.charAt(i)==')'){
                    if(st.pop()!='('){
                        return false;
                    }
                } else if(s.charAt(i)==']'){
                    if(st.pop()!='['){
                        return false;
                    }
                } else if(s.charAt(i)=='}'){
                    if(st.pop()!='{'){
                        return false;
                    }
                }
            }
        }
        if(st.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
