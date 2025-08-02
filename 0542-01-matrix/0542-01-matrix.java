class Solution {
    public int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<Node> queue = new LinkedList<>();

        int[][] ans = new int[mat.length][mat[0].length];

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true; 
                }

            }
        }

        int[] moveRow = new int[]{-1, 0, 0, 1};
        int[] moveCol = new int[]{0, -1, 1, 0};

        while(!queue.isEmpty()) {
            Node pop = queue.remove();
            int currRow = pop.row;
            int currCol = pop.col;

            ans[currRow][currCol] = pop.steps;

            for(int i = 0; i < 4; i++) {
                int newRow = currRow + moveRow[i];
                int newCol = currCol + moveCol[i];

                if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                && !visited[newRow][newCol]) {
                    queue.add(new Node(newRow, newCol, pop.steps + 1));
                    visited[newRow][newCol] = true;

                }

            }



        }

        return ans;
        
    }
}

class Node {
    int row;
    int col;
    int steps;

    public Node(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}