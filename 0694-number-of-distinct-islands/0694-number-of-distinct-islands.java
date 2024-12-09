class Solution {
    StringBuilder st = new StringBuilder();

    public int numDistinctIslands(int[][] grid) {
        int noOfIslands = 0;
        Set<String> set = new HashSet<>();

        if (grid == null || grid.length == 0) {
            return 0;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    st.setLength(0); // Reset SB before you start DFS
                    dfs(i, j, grid, "");
                    String islandName = st.toString();

                    System.out.println(islandName);

                    if (!set.contains(islandName)) {
                        noOfIslands++;
                        set.add(islandName);
                    }
                }
            }
        }


        return noOfIslands;
    }

    public void dfs(int row, int col, int[][] grid, String hint) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        // Keep appending island name and hint as you go. Use StringBuilder here for better performance
        st.append(hint);

        dfs(row + 1, col, grid, "B");
        dfs(row - 1, col, grid, "U");
        dfs(row, col + 1, grid, "R");
        dfs(row, col - 1, grid, "L");

        st.append("T"); // very important to set the hint that you are backtracking now

    }
}