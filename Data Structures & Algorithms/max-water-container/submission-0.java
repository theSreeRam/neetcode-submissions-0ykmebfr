class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int left = 0, right = heights.length - 1;
        while(left<right) {
            int water = Math.min(heights[left], heights[right]);
            // System.out.println("left:"+left+" right:"+right+ " water:"+water);
            res = Math.max(res, water*(right-left));
            if(heights[left]<heights[right]){
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
