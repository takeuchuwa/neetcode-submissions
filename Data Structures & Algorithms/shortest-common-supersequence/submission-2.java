public class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            char c1 = str1.charAt(i);
            for (int j = m - 1; j >= 0; j--) {
                char c2 = str2.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        System.out.println(dp[0][0]);

        int i = 0;
        int j = 0;
        StringBuilder res = new StringBuilder();
        while(i < n && j < m) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            if (c1 == c2) {
                res.append(c1);
                i++;
                j++;
            } else if (dp[i + 1][j] > dp[i][j + 1]) {
                res.append(c1);
                i++; 
            } else {
                res.append(c2);
                j++;
            }
        }
        while (i < n) {
            res.append(str1.charAt(i++));
        }
        while (j < m) {
            res.append(str2.charAt(j++));
        }
        return res.toString();
    }
}