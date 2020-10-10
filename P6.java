/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.字符串;

import java.util.ArrayList;
import java.util.List;

public class P6 {
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1){
                return s;
            }
            List<StringBuilder> list = new ArrayList<>();
            for (int i = 0; i < Math.min(s.length(), numRows); i++){
                list.add(new StringBuilder());
            }
            int count = 0;
            boolean flag = false;
            for (char c : s.toCharArray()){
                list.get(count).append(c);
                if (count == 0 || count == numRows - 1){
                    flag = !flag;
                }
                count += flag ? 1 : -1;
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder sb : list){
                result.append(sb);
            }
            return result.toString();

        }
    }
}
