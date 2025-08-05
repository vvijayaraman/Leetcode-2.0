class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(i, j, board, word, visited, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
        
    }

    public boolean dfs(int i, int j, char[][] board, String word,
    boolean[][] visited, int index) {
        if (index > word.length() - 1) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j] == true) {
            return false;
        }

        visited[i][j] = true;

       boolean ans1 = dfs(i+1, j, board, word, visited, index+1);
       boolean ans2 = dfs(i-1, j, board, word, visited, index+1);
       boolean ans3 = dfs(i, j+1, board, word, visited, index+1);
       boolean ans4 = dfs(i, j-1, board, word, visited, index+1);

    // backtrack
       visited[i][j] = false;

       return ans1 || ans2 || ans3 || ans4;



    }
}