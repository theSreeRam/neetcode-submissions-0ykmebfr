class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];
        
        //prefix mult
        for(int i=0; i<n; i++){
            if(i==0)
                prefix[i] = 1;
            else 
                prefix[i] = nums[i-1]*prefix[i-1];
        }

        //suffix mult
        for(int i=n-1; i>=0; i--){
            if(i==n-1)
                suffix[i] = 1;
            else 
                suffix[i] = nums[i+1]*suffix[i+1];
        }

        for(int i=0; i<n; i++){
            // System.out.println("prefix["+ i + "] :" +prefix[i]);
            // System.out.println("suffix["+ i + "] :" +suffix[i]);
            res[i] = prefix[i]*suffix[i];
        }
        return res;

    }
}  
