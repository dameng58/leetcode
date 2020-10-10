/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.字符串;

public class P5 {

    /*
        1、"aaabaaaa"    55 / 103
        2、"a"           65 / 103
        3、超时           90 / 103
     */

    class Solution {
        public String longestPalindrome(String s) {
            String str = "";
            if (s == null || "".equals(s) || s.length() <= 0){
                return str;
            }
            int len = s.length();
            int resultLen = 0;
            for (int i = 0; i < len; i++){
                for (int j = i + 1; j < len; j++){
                    String sub = s.substring(i, j);
                    if (isHuiWen(sub) && resultLen < sub.length()){
                        str = sub;
                        resultLen = sub.length();
                    }
                }
            }
            return str;
        }

        private boolean isHuiWen(String str){
            int len = str.length();
            for (int i = 0; i < len; i++){
                if (str.charAt(i) != str.charAt(len - i - 1)){
                    return false;
                }
            }
            return true;
        }

    }

    /*
        扩展中心法
     */
    class RealSolution{
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                /*
                    由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展
                    因此分为len1和len2
                 */
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        /*
            向俩边扩
         */
        private int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }

}
