/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.字符串;

public class P67 {
    /*
        共294个，只能过194个,long一样
     */
    class Solution {
        public String addBinary(String a, String b) {
            return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
        }
    }

    /*
        模拟加法
     */
    class Solution2 {
        public String addBinary(String a, String b) {
            StringBuffer ans = new StringBuffer();

            int n = Math.max(a.length(), b.length()), carry = 0;
            for (int i = 0; i < n; ++i) {
                /*
                    精髓的四行
                 */
                carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
                carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
                ans.append((char) (carry % 2 + '0'));
                carry /= 2;
            }

            if (carry > 0) {
                ans.append('1');
            }
            ans.reverse();

            return ans.toString();
        }
    }

}
