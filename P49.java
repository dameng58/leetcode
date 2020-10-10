/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultLists = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        int len = strs.length;
        if (len <= 0){
            return resultLists;
        }
        for (String str : strs){
            int key = getStrKey(str);
            List<String> tempList;
            if (!map.containsKey(key)){
                tempList = new ArrayList<>();
                tempList.add(str);
                map.put(key, tempList);
            }else {
                tempList = map.get(key);
                tempList.add(str);
            }
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()){
            List<String> tempList = entry.getValue();
            resultLists.add(tempList);
        }
        return resultLists;
    }

    private int getStrKey(String str){
        int result = 0;
        for (int i = 0; i < str.length(); i++){
            result += str.charAt(i) - 'a';
        }
        return result;
    }

}
