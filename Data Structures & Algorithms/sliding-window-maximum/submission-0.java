class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int res[] = new int[n-k+1];
        int idx = 0;

        for(int i=0; i<n; i++){
            // 1. Remove out-of-window entities
            if(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }

            // 2. maintain decreasing order
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4) record max
            if(i>= k-1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
