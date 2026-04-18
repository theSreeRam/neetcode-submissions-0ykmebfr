class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0;
        int required = t.length();   // how many chars still needed
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            // if this char was needed, reduce required
            if (need[r] > 0) {
                required--;
            }
            need[r]--;   // include it in window
            right++;

            // when window is valid
            while (required == 0) {
                // update answer
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                need[l]++;   // remove from window

                // if this char becomes needed again, window invalid
                if (need[l] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}