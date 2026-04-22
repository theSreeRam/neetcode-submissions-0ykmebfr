class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        //we'll store the indices in the stack
        Deque<Integer> st = new ArrayDeque<>();

        int res[] = new int[n];
        for(int i=n-1; i>=0; i--) {

            //remove all smaller or equal elements
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = 0; 
            } else {
                res[i] = st.peek() - i;
            }

            st.push(i);
        }

        return res;
    }
}
