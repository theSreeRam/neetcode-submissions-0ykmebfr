class Solution {

    private boolean canEat(int[] piles, int k, int h) {
        int n = piles.length;
        int res = 0;
        for(int i=0; i<n; i++){
            res += (piles[i]/k);
            if(piles[i]%k!=0){
                res++;
            }
        }
        if(res<=h) {
            return true;
        } else {
            return false;
        }
    }

    public int minEatingSpeed(int[] piles, int h) {
        // out of bounds check
        if(h<piles.length){
            return -1;
        }
        int maxInPile = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            maxInPile = Math.max(maxInPile, piles[i]);
        }
        int min = 1, max = maxInPile;
        int res = maxInPile;
        while(min<=max){
            int mid = min + (max-min)/2;
            boolean canEatRes = canEat(piles, mid, h);
            // System.out.println("min:"+min+" max:"+max+" mid:"+mid+" canEatRes:"+canEatRes);
            if(canEatRes){
                res = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return res;
    }
}
