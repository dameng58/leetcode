/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.字符串;

/*
    实现 strStr()

 */
public class P28 {
    class Solution {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }

    class Solution2 {
        public int strStr(String haystack, String needle) {
            /*
                这里的三个边界条件需要注意
             */
            if ("".equals(haystack) && "".equals(needle)){
                return 0;
            }
            if ("".equals(haystack)){
                return -1;
            }
            if ("".equals(needle)){
                return 0;
            }
            int hLen = haystack.length();
            int nLen = needle.length();
            if (nLen > hLen){
                return -1;
                /*
                    这里还需要匹配==的情况
                 */
            }else if (nLen == hLen){
                if (haystack.equals(needle)){
                    return 0;
                }else {
                    return -1;
                }
            }
            int leftPK;
            /*
                这里是<=，而不是<
             */
            for (int i = 0; i <= hLen - nLen; i++){
                leftPK = i;
                if (haystack.substring(leftPK, leftPK + nLen).equals(needle)){
                    return i;
                }
            }
            return -1;
        }
    }

}
