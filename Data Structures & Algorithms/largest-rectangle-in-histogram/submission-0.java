class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int prevSmaller[] = new int[n], nextSmaller[] = new int[n];
        // to find the index of prev smaller height
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
