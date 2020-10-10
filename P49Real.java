/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49Real {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        int len = strs.length;
        if (len <= 0){
            return resultList;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tempStr = String.valueOf(chars);
            if (!map.containsKey(tempStr)){
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(tempStr, tempList);
            }else {
                map.get(tempStr).add(str);
            }
        }
        resultList.addAll(map.values());
        return resultList;
    }
}
