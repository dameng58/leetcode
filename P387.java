/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.哈希表;

public class P387 {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++){
            char cha = s.charAt(i);

            if (s.indexOf(cha) == s.lastIndexOf(cha)){
                return i;
            }
        }
        return -1;
    }

}
