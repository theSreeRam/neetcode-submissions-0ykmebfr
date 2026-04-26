class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        //first we search from top to bottom
        int top = 0, bottom = n-1;
        int resRow = -1;
        while(top<=bottom) {
            int mid = (top+bottom)/2;
            if(matrix[mid][0]>target){
                bottom = mid-1;
            } else {
                resRow = mid;
                top = mid+1;
            }
        }
        if(resRow==-1){
            return false;
        }

        //Now do column level search
        int left = 0, right = m-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[resRow][mid]==target){
                return true;
            } else if (matrix[resRow][mid]<target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }
}
