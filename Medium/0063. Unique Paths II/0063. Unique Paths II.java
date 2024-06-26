class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i, j, row = obstacleGrid.length, col = obstacleGrid[0].length;
        if (obstacleGrid[row - 1][col - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for (i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 1) dp[0][i] = 0;
            else dp[0][i] = dp[0][i - 1];
        }
        for (i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1) dp[i][0] = 0;
            else dp[i][0] = dp[i - 1][0];
        }

        for (i = 1; i < row; i++) {
            for (j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }
}