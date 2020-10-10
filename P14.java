/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.字符串;

public class P14 {
    /*
        暴力
        2、["dog","racecar","car"]
     */
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int len = strs.length;
            if (len <= 0){
                return "";
            }
            if (len == 1){
                return strs[0];
            }

            /*
                这里需要取最短的长度
             */
            int commonLen = Integer.MAX_VALUE;
            for (String str : strs){
                commonLen = Math.min(str.length(), commonLen);
            }

            String common = strs[0];
            int i;
            for (i = 0; i < commonLen; i++){
                String temp = common.substring(0, i + 1);
                for (int j = 1; j < len; j ++){
                    String str = strs[j].substring(0, i + 1);
                    if ("".equals(str)){
                        return "";
                    }
                    if (!str.equals(temp) && i != 0){
                        return common.substring(0, i);
                    }else if (!str.equals(temp)){
                        return "";
                    }
                }
            }
            /*
                为了满足这种情况：["c","c"]
             */
            return common.substring(0, i);

        }
    }

    /*
        横向扫描，太聪了，将第一个和第二个进行比较，然后存储比较结果，随后用结果和其余进行比较。
     */
    class SmartSolution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            int count = strs.length;
            for (int i = 1; i < count; i++) {
                prefix = longestCommonPrefix(prefix, strs[i]);
                if (prefix.length() == 0) {
                    break;
                }
            }
            return prefix;
        }

        public String longestCommonPrefix(String str1, String str2) {
            int length = Math.min(str1.length(), str2.length());
            int index = 0;
            while (index < length && str1.charAt(index) == str2.charAt(index)) {
                index++;
            }
            return str1.substring(0, index);
        }
    }

}
