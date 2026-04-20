class MinStack {
    Deque<Integer> st;
    Deque<Integer> minSt;
    int minSoFar = Integer.MAX_VALUE;

    public MinStack() {
        st = new ArrayDeque<>();
        minSt = new ArrayDeque<>();
    }

    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        } else {
            minSt.push(minSt.peek());
        }
    }

    public void pop() {
        st.pop();
        minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
