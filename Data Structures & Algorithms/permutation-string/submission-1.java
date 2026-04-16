class Solution {
    
    boolean isSubString(int arr1[], int arr2[]) {
        for(int i=0; i<26; i++){
            // System.out.println("i:"+i+" arr1[i]:"+arr1[i]+",arr2[i]:"+arr2[i]);
            if(arr1[i] > arr2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int arr1[] = new int[26];
        int arr2[] = new int[26];

        if(s1.length() > s2.length()){
            return false;
        }
    
        for(int i=0; i<s1.length(); i++){
            arr1[s1.charAt(i)-'a']++;
        }
        int left = 0, right = 0;
        for(; right<s1.length(); right++){
            arr2[s2.charAt(right)-'a']++;
        }
        //now we have achieved the length of s1
        for(; right<s2.length(); right++){
            // System.out.println("left:"+left+"right:"+right+" isSubString(arr1, arr2): "+isSubString(arr1, arr2));
            if(isSubString(arr1, arr2)){
                return true;
            }
            arr2[s2.charAt(left)-'a']--;
            arr2[s2.charAt(right)-'a']++;
            left++;
        }
        return isSubString(arr1, arr2);
    }
}
