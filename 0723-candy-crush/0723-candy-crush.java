class Solution {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0) {
            return board;
        }

        boolean isDone = true;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length - 2; j++) {
                int num1 = Math.abs(board[i][j]);
                int num2 = Math.abs(board[i][j+1]);
                int num3 = Math.abs(board[i][j+2]);

                if (num1 == num2 && num2 == num3 && num1 != 0) {
                    board[i][j] = -num1;
                    board[i][j+1] = -num2;
                    board[i][j+2] = -num3;
                    isDone = false;
                }
            }
        }

         for(int i = 0; i < board.length - 2; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int num1 = Math.abs(board[i][j]);
                int num2 = Math.abs(board[i+1][j]);
                int num3 = Math.abs(board[i+2][j]);

                if (num1 == num2 && num2 == num3 && num1 != 0) {
                    board[i][j] = -num1;
                    board[i+1][j] = -num2;
                    board[i+2][j] = -num3;
                    isDone = false;
                }
            }
        }

        // Apply gravity logic
        if (!isDone) {
        for(int c = 0; c < board[0].length; c++) {
            int index = board.length - 1;

            for(int r = board.length - 1; r >=0; r--) {
                if (board[r][c] > 0) {
                    board[index][c] = board[r][c];
                    index--;
                }

            }

            for(int i = index; i >= 0; i--) {
                board[i][c] = 0;
                
            }
        }
        }


        if (isDone) {
            return board;
        } else {
            return candyCrush(board);
        }

        
    }
}