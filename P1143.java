/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.字符串;

/*
    所以可以说只要涉及子序列问题，十有八九都需要动态规划来解决。
    最长公共子序列（Longest Common Subsequence，简称 LCS）是一道非常经典的面试题目，因为它的解法是典型的二维动态规划.
 */
public class P1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        /*
            1、动态规划第一步，确定dp的含义
         */
        int[][] dp = new int[m + 1][n + 1];
        /*
            2、动态规划第二步，定义base case
            dp[0][i] = 0;
            dp[i][0] = 0;
         */
        /*
            3、动态规划第三步，找状态转移方程【较难的一步】
         */
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if (c1 == c2){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];


    }
}
