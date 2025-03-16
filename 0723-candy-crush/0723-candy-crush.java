class Solution {
    public int[][] candyCrush(int[][] board) {

        // Tag elements that are repeating and could be crushed + Apply the gravity logic once crushed

        // 1 - Iterate all rows and tag the element
        boolean done = true;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length - 2; j++) {
                int num1 = Math.abs(board[i][j]);
                int num2 = Math.abs(board[i][j+1]);
                int num3 = Math.abs(board[i][j+2]);

                if (num1 == num2 && num2 == num3 && num1 != 0) {
                    board[i][j] = -num1;
                    board[i][j+1] = -num2;
                    board[i][j+2] = -num3;
                    done = false;
                }
            }
        }
         
        // 2 - Iterate all cols and tag the element
         for(int i = 0; i < board.length - 2; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int num1 = Math.abs(board[i][j]);
                int num2 = Math.abs(board[i+1][j]);
                int num3 = Math.abs(board[i+2][j]);

                if (num1 == num2 && num2 == num3 && num1 != 0) {
                    board[i][j] = -num1;
                    board[i+1][j] = -num2;
                    board[i+2][j] = -num3;
                    done = false;
                }
            } 
        }



    
          // Apply gravity logic for all zeroes
          if (!done) {
            for(int c = 0; c < board[0].length; c++) {
                int index = board.length - 1;

                for(int r = board.length - 1; r >= 0; r--) {
                    if (board[r][c] > 0) {
                        board[index][c] = board[r][c];
                        index--;
                }
            }

                for(int r = index; r >= 0; r--) {
                    board[r][c] = 0;
                }
            }
          }
           

        if (done) {
            return board;
        } else {
            return candyCrush(board);
        }
        
    }
}