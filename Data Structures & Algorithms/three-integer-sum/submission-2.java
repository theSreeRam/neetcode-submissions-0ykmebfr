class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // for(int num:nums){
        //     System.out.print(num + ",");
        // }
        // System.out.println("");
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++){

            if(i>0 && nums[i]==nums[i-1]){continue;}

            int left = i+1, right = nums.length-1;
            // System.out.println("i:"+i+" nums[i]: "+nums[i]+" left:"+left+" nums[left]:"+nums[left]+" right:"+right+" nums[right]:"+nums[right]);
            while(left < right) {
            int sum = nums[i] + nums[left] + nums[right];
                if(sum==0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) {left++;}
                    while(left<right && nums[right]==nums[right+1]) {right--;}

                } else if (sum<0) {
                    left++;
                    // System.out.println("1st i:"+i+" nums[i]: "+nums[i]+" left:"+left+" nums[left]:"+nums[left]+" right:"+right+" nums[right]:"+nums[right]);
                    
                } else {
                    // System.out.println("2nd i:"+i+" nums[i]: "+nums[i]+" left:"+left+" nums[left]:"+nums[left]+" right:"+right+" nums[right]:"+nums[right]);

                    right--;
                }
            }
        }
        return res;
    }
}
