class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int n = s.length();
        int left = 0, maxLen = 0;
        for(int right = 0; right < n; right++){
            char ch= s.charAt(right);
            if(lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch)+1);
            }
            lastSeen.put(ch, right);
            maxLen = Math.max(maxLen, right-left+1);

        }
        return maxLen;
    }
}
