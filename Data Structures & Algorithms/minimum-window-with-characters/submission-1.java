class Solution {
    public String minWindow(String s, String t) {
        int arrT[] = new int[128], arrS[] = new int[128];
        for(int i=0; i<t.length(); i++){
            arrT[t.charAt(i)]++;
        }
        int haves=0, needs=0;
        for(int i=0; i<128; i++){
            if(arrT[i]>0){
                needs++;
            }
        }
        int resStart=0, resLen = Integer.MAX_VALUE, left=0; 
        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            arrS[c]++;

            if(arrT[c]>0 && arrS[c]==arrT[c]){
                haves++;
            }

            while(haves==needs){
                //we can contract
                if(resLen > (right-left+1)) {
                resLen = Math.min(resLen, right-left+1);
                resStart = left;
                }
                char leftChar = s.charAt(left);
                arrS[leftChar]--;
                if (arrT[leftChar] > 0 && arrS[leftChar] < arrT[leftChar]) {
                    haves--;
                }
                left++;
            }
        }
        if (resLen==Integer.MAX_VALUE){
            return "";
        } else {
            return s.substring(resStart, resStart+resLen);
        }
    }
}
