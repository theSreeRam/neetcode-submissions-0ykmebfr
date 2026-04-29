class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        
        int pivot = nums[0];
        if(n==1){
            return pivot;
        }
        if(nums[left]<nums[right]){
            //this means array is sorted
            return nums[left];
        }
        int res = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<pivot){
                //we want this result
                res = Math.min(res, nums[mid]);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return res;
    }
}
