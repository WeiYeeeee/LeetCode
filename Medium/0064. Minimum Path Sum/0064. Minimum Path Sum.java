class Solution {
    public int minPathSum(int[][] grid) {
        int i, j, row = grid.length, col = grid[0].length;
        for (i = 1; i < col; i++) grid[0][i] += grid[0][i - 1];
        for (i = 1; i < row; i++) grid[i][0] += grid[i - 1][0];

        for (i = 1; i < row; i++) {
            for (j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[row - 1][col - 1];
    }
}