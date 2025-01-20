class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {

        // no of rows will become no of columns and vice versa
        char[][] output = new char[boxGrid[0].length][boxGrid.length];

        // first rotate array 90 degrees
        // flip it and then reverse the rows
        for(int i = 0; i < boxGrid.length; i++) {
            for(int j = 0; j < boxGrid[0].length; j++) {
                char currVal = boxGrid[i][j];
                output[j][i] = currVal;
            }
        }

        // reverse the rows
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[0].length / 2; j++) {
                char temp = output[i][j];
                output[i][j] = output[i][output[0].length - j - 1];
                output[i][output[0].length - j - 1] = temp;
            }
        }

        // For each row, column, do the gravity logic. Gravity logic has to start from bottom
        for(int i = output.length - 2; i >= 0; i--) {
            for(int j = 0; j < output[0].length; j++) {
                boolean stop = false;
                int currRow = i;
                int currCol = j;

                while(currRow >= 0 && !stop) { 
                    if (output[currRow][currCol] == '#') {
                        if (output[currRow + 1][currCol] == '*' || output[currRow + 1][currCol] == '#') { 
                            stop = true; 
                        } else if (output[currRow + 1][currCol] == '.') {
                            int tempRow = currRow;
                            while (tempRow < output.length - 1 && output[tempRow + 1][currCol] == '.') {
                                output[tempRow + 1][currCol] = output[tempRow][currCol]; 
                                output[tempRow][currCol] = '.'; 
                                tempRow++;

                            } 
                        } 
                    }
                    currRow--;
                }
            }
        }

        return output;
    }
}