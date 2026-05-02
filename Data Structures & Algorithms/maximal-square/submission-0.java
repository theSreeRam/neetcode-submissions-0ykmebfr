class Solution {

    public int helper(int i, int j, char[][] matrix, int[][] dp) {
        int n = matrix.length, m = matrix[0].length;
        if(i>=n || j>=m){
            return 0;
        }
        // if already visited
        if(dp[i][j]!=-1){
            return dp[i][j];
        } 

        if(matrix[i][j]=='0'){
            return dp[i][j] = 0;
        }

        // calculate across directions
        int right = helper(i, j+1, matrix, dp);
        int bottom = helper(i+1, j, matrix, dp);
        int diag = helper(i+1, j+1, matrix, dp);

        dp[i][j] = 1 + Math.min(right, Math.min(bottom, diag));

        return dp[i][j];
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int dp[][] = new int[n][m];
        for(int[] row: dp) { Arrays.fill(row, -1);};

        int res = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res = Math.max(res, helper(i, j, matrix, dp));
            }
        }
        return res*res;
    }
}