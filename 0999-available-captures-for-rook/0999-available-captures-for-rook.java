class Solution {
    int attack = 0;

    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    move(board, i, j);
                }
            }
        }
        return attack;
    }

    public void move(char[][] board, int i, int j) {
        int[] rDirections = new int[]{-1, 0, 0, 1};
        int[] cDirections = new int[]{0, 1, -1, 0};

        for (int k = 0; k < 4; k++) {
            int newRow = i;
            int newCol = j;

            while (true) {
                newRow += rDirections[k];
                newCol += cDirections[k];

                if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                    break; // Stop if out of bounds
                }

                if (board[newRow][newCol] == 'p') {
                    attack++;
                    break; // Stop after capturing a pawn
                }

                if (board[newRow][newCol] == 'B') {
                    break; // Stop if a bishop is encountered
                }
            }
        }
    }
}