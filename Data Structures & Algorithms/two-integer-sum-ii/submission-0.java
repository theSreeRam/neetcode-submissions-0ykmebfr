class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int curr = numbers[start] + numbers[end];
        while(curr!=target) {
            if(curr<target){
                start++;
            } else {
                end--;
            }
            curr = numbers[start] + numbers[end];
        }
        return new int[]{start+1, end+1};
    }
}
