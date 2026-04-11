class Solution {

    private boolean isAlphaNum(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {

            while (start < end && !isAlphaNum(s.charAt(start))) start++;
            while (start < end && !isAlphaNum(s.charAt(end))) end--;

            char left = Character.toLowerCase(s.charAt(start));
            char right = Character.toLowerCase(s.charAt(end));

            if (left != right) return false;

            start++;
            end--;
        }
        return true;
    }
}