class Solution {
    public int findMin(int[] nums) {
        int n = nums.length, pivot = nums[0];
        int left = 0, right = n-1;
        int res = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right-left)/2;
            System.out.println("left:"+left+",right:"+right+",mid:"+mid);
            if(nums[mid]<pivot){
                //true scenario, dont need to include in answer
                // find the first true, move to right
                res = Math.min(res, nums[mid]);
                System.out.println("first, res:"+res);
                right = mid-1;
            } else {
                System.out.println("second, res:"+res);
                left = mid+1;
            }
        }
        //sanity check
        if(res==Integer.MAX_VALUE) {
            return pivot;
        }
        return res;
    }
}
