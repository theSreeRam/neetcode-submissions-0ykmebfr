class Solution {

    public int countMaxFrequency(int arr[]) {
        int res = 0;
        for(int i=0; i<26; i++){
            res = Math.max(res, arr[i]);
        }
        return res;
    }

    public int characterReplacement(String s, int k) {
        // sliding window again, 
        // have to track how many distinct alphabets

        int left = 0, lenMax = 0;
        int arr[] = new int[26];

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            arr[ch-'A']++;
            while(((right-left+1) - countMaxFrequency(arr))>k){
                //we have to shrink the window
                arr[s.charAt(left)-'A']--;
                left++;
            } 
            //we are good
            lenMax = Math.max(lenMax, right-left+1);
        }
        return lenMax;
    }
}
