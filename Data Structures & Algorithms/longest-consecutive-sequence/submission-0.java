class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> mp = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            mp.add(nums[i]);
        }

        int res = 0;
        for(int i=0; i<nums.length; i++){
            //Case where this is the start of a sequence
            if (mp.contains(nums[i]-1)==false){
                int currSequenceLength = 1;
                int num = nums[i];
                while(mp.contains(num+1)){
                    currSequenceLength++;
                    num++;
                }
                res = Math.max(res, currSequenceLength);
            }
        }
        return res;
    }
}
