class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        final int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i <= len; i++) {

            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7') dp[i] += dp[i - 2];
            if (s.charAt(i - 1) != '0') dp[i] += dp[i-1];
        }
        
        return dp[len];
    }
}