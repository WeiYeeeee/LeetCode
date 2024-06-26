class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len3 != len1 + len2)
            return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        int i, j;
        for (i = 0; i < len1; i++)
            dp[i + 1][0] = dp[i][0] & (s1.charAt(i) == s3.charAt(i));
        for (i = 0; i < len2; i++)
            dp[0][i + 1] = dp[0][i] & (s2.charAt(i) == s3.charAt(i));

        for (i = 1; i <= len1; i++)
            for (j = 1; j <= len2; j++)
                // 目前 第 i + j 個，判斷 i + j - 1
                dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || // 為 i + (j - 1) -> i +
                                                                                         // j，為j增加，代表目前是判斷s2
                        (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));

        return dp[len1][len2];
    }
}