/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.字符串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P3 {

    class Solution {


        public int lengthOfLongestSubstring(String s) {
            if (s == null || "".equals(s) || s.length() <= 0){
                return 0;
            }
            if (s.length() == 1){
                return 1;
            }
            int result = 1;
            List<Character> list = new ArrayList<>();
            int leftPK = 0;
            int rightPK = 1;
            list.add(s.charAt(0));
            while (rightPK < s.length()){
                char cha = s.charAt(rightPK);
                if (!list.contains(cha)){
                    list.add(cha);
                }else {

                    int index = list.indexOf(cha);
                    for (int i = 0; i < index; i++){
                        list.remove(i);
                        leftPK++;
                    }
                    list.add(cha);
                }
                result = Math.max(rightPK - leftPK + 1, result);
                rightPK++;

            }
            return result;
        }
    }

    /*
        realTalk
     */
    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }

}
