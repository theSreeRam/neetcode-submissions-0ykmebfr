class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<9; i++){
            
            //row check
            boolean[] rowVisited = new boolean[10];
            for(int j=0; j<9; j++){
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if(rowVisited[num]==true){
                    return false;
                } else {
                    rowVisited[num] = true;
                }
            }

            //col check
            boolean[] colVisited = new boolean[10];
            for(int j=0; j<9; j++){
                if (board[j][i] == '.') continue;
                int num = board[j][i] - '0';
                if(colVisited[num]==true){
                    return false;
                } else {
                    colVisited[num] = true;
                }
            }

            //grid check
            boolean[] gridVisited = new boolean[10];
            int x = (i/3)*3;   
            int y = (i%3)*3;

            for(int row = x; row < x+3; row++){
                for(int col = y; col<y+3; col++){
                    
                    if (board[row][col] == '.') continue;
                    int num = board[row][col] - '0';

                    if(gridVisited[num]==true){
                        return false;
                    } else {
                        gridVisited[num] = true;
                    }
                }
            }
        }
        return true;
    }
}
