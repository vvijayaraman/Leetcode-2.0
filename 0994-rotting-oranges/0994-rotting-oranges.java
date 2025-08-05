class Solution {
    int minutes = 0;
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        while(!queue.isEmpty()) {

            Node pop = queue.remove();
            int[] moveRow = new int[]{-1, 0, 1, 0};
            int[] moveCol = new int[]{0, 1, 0, -1};

            for(int i = 0; i < 4; i++) {
                int nRow = pop.row + moveRow[i];
                int nCol = pop.col + moveCol[i];

                if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length 
                && visited[nRow][nCol] == false && grid[nRow][nCol] == 1) {
                    grid[nRow][nCol] = 2;
                    visited[nRow][nCol] = true;
                    queue.add(new Node(nRow, nCol, pop.minutes + 1));

                }

            }

            minutes = pop.minutes;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }


        return minutes;
        
    }

    class Node {
        int row;
        int col;
        int minutes;
        
        public Node(int row, int col, int minutes) {
            this.row = row;
            this.col = col;
            this.minutes = minutes;
        }
    }


}