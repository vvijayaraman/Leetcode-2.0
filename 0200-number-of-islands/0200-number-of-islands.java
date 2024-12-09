class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(i, j, grid);
                }
            }
        }

        return numberOfIslands;
        
    }

    public void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        
        dfs(row + 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row - 1, col, grid);
        dfs(row, col - 1, grid);


    }
}