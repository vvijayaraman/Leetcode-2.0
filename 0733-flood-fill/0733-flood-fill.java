class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];

        for(int i = sr; i < image.length; i++) {
            for (int j = sc; j < image[0].length; j++) {
                dfs(image, visited, color, sr, sc, image[sr][sc]);
            }
        }

        return image;
        
        
    }

    public void dfs(int[][] image, boolean[][] visited, int finalColor, int row, int col, int startingColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return;
        }

        if (!visited[row][col]) {
            visited[row][col] = true;

            if (image[row][col] == startingColor) {
                image[row][col] = finalColor;
            } else {
                return;
            }

            dfs(image, visited, finalColor, row + 1, col, startingColor);
            dfs(image, visited, finalColor, row - 1, col, startingColor);
            dfs(image, visited, finalColor, row, col + 1, startingColor);
            dfs(image, visited, finalColor, row, col - 1, startingColor);

        }

    }
}